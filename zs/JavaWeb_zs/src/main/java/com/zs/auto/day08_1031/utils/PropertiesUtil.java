package com.zs.auto.day08_1031.utils;

import java.io.IOException;
import java.util.Properties;


/**
 * 为了只加载一次文件
 * @author Administrator
 *
 */
public class PropertiesUtil {
    
    //读取url配置文件的对象
    private static Properties properties = new Properties();
    //get方法
    public static String gerUrl(String urlKey) {
        return properties.getProperty(urlKey);
    }
    /**
     * 保证加载遍
     */
    static{
        try {
            properties.load(PropertiesUtil.class.getResourceAsStream("/properties/test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println(properties.getProperty("login_url"));
        
        System.out.println(gerUrl("login_url"));
    }

}
