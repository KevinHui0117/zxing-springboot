package com.zgh.xxg.xxg.util;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileCheckUtil {

	private static Set<String> photoExtension=new HashSet<String>();
	private static Set<String> videoExtension=new HashSet<String>();
	private static Set<String> fileExtension=new HashSet<String>();
	private static Map<String,String> typeCodeMap=new HashMap<String,String>();
	
	static{
		if(StringUtils.isNotBlank(SystemProperty.getProperty("photoExtension"))){
			String[] strs= SystemProperty.getProperty("photoExtension").split(",");
			for(String str:strs){
				if(str.startsWith(".")){
					str=str.substring(1);
				}
				if(!"svg".equals(str)){
					photoExtension.add(str);
				}
				fileExtension.add(str);
			}
		}else{
			photoExtension.add("jpg");
			photoExtension.add("jpeg");
			photoExtension.add("gif");
			photoExtension.add("bmp");
			photoExtension.add("png");
		}
		
		if(StringUtils.isNotBlank(SystemProperty.getProperty("videoExtension"))){
			String[] strs= SystemProperty.getProperty("videoExtension").split(",");
			for(String str:strs){
				if(str.startsWith(".")){
					str=str.substring(1);
				}
				videoExtension.add(str);
				fileExtension.add(str);
			}
		}else{
			videoExtension.add("wmv");
			videoExtension.add("avi");
			videoExtension.add("rm");
			videoExtension.add("mp4");
		}
		
		if(StringUtils.isNotBlank(SystemProperty.getProperty("fileExtension"))){
			String[] strs= SystemProperty.getProperty("fileExtension").split(",");
			for(String str:strs){
				if(str.startsWith(".")){
					str=str.substring(1);
				}
				fileExtension.add(str);
			}
		}else{
			fileExtension.add("ppt");
			fileExtension.add("pptx");
			fileExtension.add("doc");
			fileExtension.add("docx");
			fileExtension.add("xls");
			fileExtension.add("xlsx");
			fileExtension.add("pdf");
			fileExtension.add("rar");
			fileExtension.add("zip");
			fileExtension.add("txt");
			fileExtension.add("rtf");
			fileExtension.add("xml");
		}
		
		typeCodeMap.put("jpg", "FFD8FF");
		typeCodeMap.put("jpeg", "FFD8FF");
        typeCodeMap.put("png", "89504E47");
        typeCodeMap.put("gif", "47494638");
        typeCodeMap.put("bmp", "424D"); 
        
        typeCodeMap.put("tif", "49492A00");
        typeCodeMap.put("dwg", "41433130");
        typeCodeMap.put("psd", "38425053"); //PhotoShop
        typeCodeMap.put("pst", "2142444E"); //Outlook 

        typeCodeMap.put("avi", "41564920");     
        typeCodeMap.put("ram", "2E7261FD"); //Real Audio     
        typeCodeMap.put("rm", "2E524D46"); //Real Media 
        typeCodeMap.put("mpg", "000001BA");     
        typeCodeMap.put("mov", "6D6F6F76"); //Quicktime  
        
        typeCodeMap.put("office", "D0CF11E0"); //office类型，包括doc、xls和ppt 
        typeCodeMap.put("doc", "D0CF11E0"); 
        typeCodeMap.put("docx", "D0CF11E0"); 
        typeCodeMap.put("xls", "D0CF11E0"); 
        typeCodeMap.put("xlsx", "D0CF11E0"); 
        typeCodeMap.put("ppt", "D0CF11E0"); 
        typeCodeMap.put("pptx", "D0CF11E0"); 
        
        typeCodeMap.put("pdf", "255044462D312E"); //Adobe Acrobat  
        typeCodeMap.put("rtf", "7B5C727466"); //Rich Text Format    
       
        typeCodeMap.put("zip", "504B0304");     
        typeCodeMap.put("rar", "52617221");   
        
        typeCodeMap.put("xml", "3C3F786D6C");     
        typeCodeMap.put("html", "68746D6C3E"); //HTML   
        typeCodeMap.put("eml", "44656C69766572792D646174653A"); //Email [thorough only] 
        typeCodeMap.put("dbx", "CFAD12FEC5FD746F"); //Outlook Express  
          
        typeCodeMap.put("mdb", "000100005374616E64617264204A"); //MS Access     
        typeCodeMap.put("wpd", "FF575043"); //WordPerfect   
        typeCodeMap.put("eps", "252150532D41646F6265");     
        typeCodeMap.put("ps", "252150532D41646F6265");     
         
        typeCodeMap.put("qdf", "AC9EBD8F"); //Quicken  
        typeCodeMap.put("pwl", "E3828596"); //Windows Password 
        typeCodeMap.put("wav", "57415645"); //Wave   
         
        typeCodeMap.put("asf", "3026B2758E66CF11"); //Windows Media    
        typeCodeMap.put("mid", "4D546864");
		
	}
	
	public static boolean checkFile(byte[] file,String fileName){
		//检查文件内容是否有
		if (file == null || file.length <= 0) {
            return false;
        }
		//获取文件扩展名
		String fileType= "";
		int n = fileName.lastIndexOf('.');
		if (n > 0) {
		    fileType= fileName.substring(n+1);
		}
		if(StringUtils.isBlank(fileType)){
			return false;
		}
		//检查文件扩展名
		if(!checkFileExt(fileType)){
			return false;
		}
		//对图片的特别检查
		if(photoExtension.contains(fileType)){
			if(!isImage(file)){
				return false;
			}
		}
		/*//检查文件的头部字符
		String typeCode=typeCodeMap.get(fileType);
		if(StringUtils.isNotBlank(typeCode)){
			StringBuilder stringBuilder = new StringBuilder();
		   
	        for (int i = 0; i < 4; i++) {
	            int v = file[i] & 0xFF;
	            String hv = Integer.toHexString(v).toUpperCase();
	            if (hv.length() < 2) {
	                stringBuilder.append(0);
	            }
	            stringBuilder.append(hv);
	        }
	        return stringBuilder.toString().startsWith(typeCode);
		}*/
		
		return true;
	}
	
	
	private static boolean checkFileExt(String fileType){
		if(photoExtension.contains(fileType)){
			return true;
		}
		if(videoExtension.contains(fileType)){
			return true;
		}
		if(fileExtension.contains(fileType)){
			return true;
		}
		return false;
	}
	
	

    
    public static boolean isImage(String fileAddress) {
        Image img = null;
        try { 
        	File file=new File(new URI(fileAddress));
            img = ImageIO.read(file);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            img = null;
        }
    }
    
    public static boolean isImage(byte[] imageFile) {
        Image img = null;
        try { 
            img = ImageIO.read(new ByteArrayInputStream(imageFile));
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            img = null;
        }
    }
    
    public static boolean isImage(File imageFile) {
        if (!imageFile.exists()) {
            return false;
        }
        Image img = null;
        try {
            img = ImageIO.read(imageFile);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            img = null;
        }
    }
    

}
