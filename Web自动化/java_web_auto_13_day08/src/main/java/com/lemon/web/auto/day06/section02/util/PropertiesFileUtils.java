package com.lemon.web.auto.day06.section02.util;

import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesFileUtils：为了只加载一遍
 * @author happy
 *
 */
public class PropertiesFileUtils {
	// 这个是读取url属性文件的对象--》
	private static Properties urlProperties = new Properties();
	private static Properties configProperties = new Properties();

	/**
	 * 保证加载一遍
	 */
	static {
		try {
			urlProperties.load(PropertiesFileUtils.class.getResourceAsStream("/url.properties"));
			configProperties.load(PropertiesFileUtils.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUrl(String urlKey){
		return urlProperties.getProperty(urlKey);
	}
	
	public static String getConfig(String configKey){
		return configProperties.getProperty(configKey);
	}

	public static void main(String[] args) {

//		System.out.println(urlProperties.get("login_url"));
//		System.out.println(getUrl("login_url"));
		System.out.println(getConfig("aa"));
	}

}
