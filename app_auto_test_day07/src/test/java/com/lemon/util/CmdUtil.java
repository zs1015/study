package com.lemon.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @Title: CmdUtil.java
 * @Description: TODO(dos命令的工具类)
 * @author 歪歪欧巴
 * @date 2019年11月26日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class CmdUtil {
	
	private static Logger logger = Logger.getLogger(CmdUtil.class);
	/**
	 * 执行dos下的命令
	 * 
	 * @param cmd
	 */
	public static List<String> execCmd(String cmd) {
		// 1、实例化runTime对象 （程序运行时对象）
		Runtime runtime = Runtime.getRuntime();
		try {
			// 2、调用runtime对象的exec方法
			// process:执行命令的对应进程
			//cmd /c在后台重新开辟一个窗口去执行dos命令
			Process process = runtime.exec("cmd /c "+cmd);
			// 3、得到命令的输出
			InputStream inputStream = process.getInputStream();
			// 把字节流转换成字符流
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
			// 用缓冲读取字符流的内容
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = "";
			List<String> content = new ArrayList<String>();
			// 用循环读取内容
			while ((line = (bufferedReader.readLine())) != null) {
				//加一个判断：判断Appium是否启动成功
				if(line.contains("Appium REST http interface listener started on")){
					String[] str = line.split("on");
					logger.info("Appium启动成功:【"+str[1]+"】");
				}
				content.add(line);
			}
			return content;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到当前链接到PC端的所有设备
	 */
	public static List<String> getDeviceLists() {
		List<String> result = execCmd("adb devices");
		List<String> deviceList = new ArrayList<String>();
		for (int i = 0; i < result.size(); i++) {
			// 1、跳过这一行“List of devices attached”,跳过最后一行
			if (i != 0 && i != (result.size() - 1)) {
				// 对集合的元素进行分割--正则表达式
				// 以空白字符(\s)作为分割的标记 第一个：emualor-5554 第一个：device
				String[] splitArr = result.get(i).split("\\s");
				deviceList.add(splitArr[0]);
			}
		}
		if(deviceList.size()==0){
			logger.error("设备没有检测到，请检查");
			// 程序运行到这里没有必要再去执行下面的动作了,程序直接结束掉
			//如果为0：程序正常结束掉
			//如果为-1：程序异常终止掉  
			System.exit(0);
		}
		return deviceList;
	}

	public static void main(String[] args) {
		String str = "[Appium] Appium REST http interface listener started on 127.0.0.1:4725";
		String [] splitInfos = str.split("on");
		System.out.println(splitInfos[1]);
	}
}
