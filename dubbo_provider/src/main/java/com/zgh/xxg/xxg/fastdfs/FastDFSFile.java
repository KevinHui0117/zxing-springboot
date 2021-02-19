package com.zgh.xxg.xxg.fastdfs;

public class FastDFSFile {


    private byte[] content; //文件内容
    private String name;	//文件原始名称
    private String ext;		//扩展名
    private String author;	//上传作者
    private String createTime;		//上传时间
    
    private long length;	//大小
    private String groupName;		//上传后返回的组名
    private String remoteFileName;	//上传后返回的文件名
    

	public FastDFSFile(byte[] content, String name, String ext,String author) {
		super();
		this.content = content;
		this.name = name;
		this.ext = ext;
		this.author = author;
		if(content!=null){
			this.length=content.length;
		}
	}
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getRemoteFileName() {
		return remoteFileName;
	}
	public void setRemoteFileName(String remoteFileName) {
		this.remoteFileName = remoteFileName;
	}
	
    
    
}
