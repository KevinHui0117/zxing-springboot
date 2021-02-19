/**
 * 
 */
package com.zgh.xxg.xxg.fastdfs;


import com.zgh.xxg.xxg.util.SystemProperty;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author csz
 *
 */
public class FastDFSUtil {

    /**
     * FastDFS组名称映射
     */
    public static final String DFS_GROUP_CLOUDSPACE = "group1";//云空间存储的组
    public static final String DFS_GROUP_OTHERSPACE = "group2";//其他存储的组

    /**
     * FastDFS存文件上传用途分类（1：云空间存储，2：其他存储）
     */
    public static final int DFS_STORE_TYPE_CLOUDSPACE = 1;
    public static final int DFS_STORE_TYPE_OTHERSPACE = 2;
    
    
	
	private static final Logger logger = LoggerFactory
			.getLogger(FastDFSUtil.class);
	
	private static final String HTTP_ADDRESS = "http.address";
	private static final String HTTP_SECRET_KEY = "http.secret_key";
	
	private static TrackerServerPool pool = new TrackerServerPool(5, 10, 200);
	
	
	public static String  exists(String remoteFileName){
			return exists(getGroupName(remoteFileName),getFileName(remoteFileName));
	}
	
	public static String exists(String groupName,String remoteFileName){
		TrackerServer trackerServer = null;
		try {
			trackerServer = pool.checkout();
			StorageServer storageServer = null;
			StorageClient1 client1 = new StorageClient1(trackerServer,
					storageServer);
			FileInfo fileInfo=client1.get_file_info(groupName,remoteFileName);
			pool.checkin(trackerServer);
			if(fileInfo==null){
				return "0";
			}
			return  "1";
		} catch (Exception ex) {
			logger.error("检查文件是否存在fastDFS异常,文件：" + remoteFileName, ex);
			return "0";
		} finally {
			pool.drop(trackerServer);
		}
	}
	
	public static String upload(FastDFSFile file) {
		TrackerServer trackerServer = null;
		try {
			trackerServer = pool.checkout();
			StorageServer storageServer = null;
			StorageClient1 client1 = new StorageClient1(trackerServer,
					storageServer);
			String groupName = null;
			if(StringUtils.isNoneBlank(file.getGroupName())){
				groupName=file.getGroupName();
			}
			NameValuePair[] nameValuePair = new NameValuePair[2];
			nameValuePair[0] = new NameValuePair("fileName", file.getName());
			nameValuePair[1] = new NameValuePair("fileAuthor", file.getAuthor());
			String[] uploadResults = client1.upload_appender_file(groupName,
					file.getContent(), file.getExt(), nameValuePair);
			pool.checkin(trackerServer);
			file.setGroupName(uploadResults[0]);
			file.setRemoteFileName(uploadResults[1]);
			return file.getGroupName()+"/"+file.getRemoteFileName();
		} catch (Exception ex) {
			logger.error("上传文件到fastDFS异常,文件：" + file.getName(), ex);
			return null;
		} finally {
			pool.drop(trackerServer);
		}
	}
	
	public static void append(byte[] content,String remoteFileName) {
		append(content,getGroupName(remoteFileName),getFileName(remoteFileName));
	}
	
	public static void append(byte[] content,String groupName, String remoteFileName) {
		if(content==null || content.length==0){
			return;
		}
		TrackerServer trackerServer = null;
		try {
			trackerServer = pool.checkout();
			StorageServer storageServer = null;
			StorageClient1 client1 = new StorageClient1(trackerServer,
					storageServer);
			client1.append_file(groupName, remoteFileName, content);
			pool.checkin(trackerServer);

		} catch (Exception ex) {
			logger.error("更新fastDFS文件异常：" + groupName + "/" + remoteFileName, ex);
		} finally {
			pool.drop(trackerServer);
		}
	}

	public static void delete(String remoteFileName) {
		delete(getGroupName(remoteFileName),getFileName(remoteFileName));
	}
	
	public static void delete(String groupName, String remoteFileName) {
		TrackerServer trackerServer = null;
		try {
			trackerServer = pool.checkout();
			StorageServer storageServer = null;
			StorageClient1 client1 = new StorageClient1(trackerServer,
					storageServer);
			client1.delete_file(groupName, remoteFileName);
			pool.checkin(trackerServer);
		} catch (Exception ex) {
			logger.error(
					"删除fastDFS文件异常,文件：" + groupName + "/" + remoteFileName, ex);
		} finally {
			pool.drop(trackerServer);
		}
	}
	
	public static ResponseEntity<byte[]> httpDownload(String remoteFileName, String specFileName) {
		return httpDownload(getGroupName(remoteFileName), getFileName(remoteFileName), specFileName);
	}
	public static ResponseEntity<byte[]> httpDownload(String groupName,
			String remoteFileName, String specFileName) {
		byte[] content = null;
		HttpHeaders headers = new HttpHeaders();
		TrackerServer trackerServer = null;
		try {
			trackerServer = pool.checkout();
			StorageServer storageServer = null;
			StorageClient1 client1 = new StorageClient1(trackerServer,
					storageServer);
			content = client1.download_file(groupName, remoteFileName);
			if (content != null  && content.length>0) {
				headers.setContentDispositionFormData("attachment", new String(
						specFileName.getBytes("UTF-8"), "iso-8859-1"));
				// headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			}
			pool.checkin(trackerServer);
		} catch (Exception ex) {
			logger.error(
					"下载fastDFS文件异常,文件：" + groupName + "/" + remoteFileName, ex);
		} finally {
			pool.drop(trackerServer);
		}
		return new ResponseEntity<byte[]>(content, headers, HttpStatus.CREATED);
	}

	public static byte[] byteDownload(String remoteFileName) {
		return byteDownload(getGroupName(remoteFileName), getFileName(remoteFileName));
	}
	public static byte[] byteDownload(String groupName, String remoteFileName) {
		byte[] content = null;
		TrackerServer trackerServer = null;
		try {
			trackerServer = pool.checkout();
			StorageServer storageServer = null;
			StorageClient1 client1 = new StorageClient1(trackerServer,
					storageServer);
			content = client1.download_file(groupName, remoteFileName);
			pool.checkin(trackerServer);
		} catch (Exception ex) {
			logger.error(
					"下载fastDFS文件异常,文件：" + groupName + "/" + remoteFileName, ex);
		} finally {
			pool.drop(trackerServer);
		}
		return content;
	}

	
	public static String getHttpPath(String remoteFileName) {
		return getHttpPath(getGroupName(remoteFileName), getFileName(remoteFileName));
	}
	public static String getHttpPath(String groupName, String remoteFileName) {
		String secretKey= SystemProperty.getProperty(HTTP_SECRET_KEY);
		int ts = (int) (System.currentTimeMillis() / 1000);
        String token=null;
		try {
			token = ProtoCommon.getToken(remoteFileName, ts, secretKey);
		} catch (UnsupportedEncodingException e) {
			
		} catch (NoSuchAlgorithmException e) {
			
		} catch (MyException e) {
			
		}
		StringBuffer sb = new StringBuffer();
		sb.append(SystemProperty.getProperty(HTTP_ADDRESS))
				.append("/").append(groupName)
				.append("/").append(remoteFileName)
				.append("?token=")
				.append(token)
				.append("&ts=")
				.append(ts);
		return sb.toString();
	}

	public static String getGroupName(String remoteFileName){
		if(StringUtils.isBlank(remoteFileName)){
			return null;
		}
		if(!remoteFileName.startsWith("group")){
			return null;
		}
		int n=remoteFileName.indexOf("/");
		String groupName=remoteFileName.substring(0,n);
		return groupName;
	}
	
	public static String getFileName(String remoteFileName){
		if(StringUtils.isBlank(remoteFileName)){
			return null;
		}
		if(!remoteFileName.startsWith("group")){
			return remoteFileName;
		}
		int n=remoteFileName.indexOf("/");
		String fileName=remoteFileName.substring(n+1);
		return fileName;
	}
	
}
