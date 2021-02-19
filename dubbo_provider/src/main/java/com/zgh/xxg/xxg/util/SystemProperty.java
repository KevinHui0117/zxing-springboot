package com.zgh.xxg.xxg.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**加载所有的properties文件到缓存中
 */

public class SystemProperty {

	private static final String path = "classpath:*.properties";

	private static Map<String, String> map = new ConcurrentHashMap<String, String>();

	static{
		loadSysProperties();
	}

	public static String getProperty(String propertyName) {
		return map.get(propertyName);
	}


	public static void loadSysProperties() {
		Properties properties = new Properties();
		try {
			Resource[] resources = ResourceUtils.getResources(path);

			for (int i = 0; i < resources.length; i++) {
				Properties p = PropertiesLoaderUtils.loadProperties(resources[i]);
				properties.putAll(p);
			}
			properties.put("systemIp", InetAddress.getLocalHost().getHostAddress());
		} catch (IOException ex) {
			throw new RuntimeException("加载系统配置项出现异常");
		}

		Enumeration names = properties.propertyNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = properties.getProperty(name);
			map.put(name, value);
		}

	}

	public  static void setMap( Map<String, String> map ){
		SystemProperty.map.putAll(map);
	}
	
	
}
