package com.lemon.web.auto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.lemon.web.auto.pojo.Locator;

/**
 * 怎么找登录按钮：找到登录页面--》找出登录按钮--》登录按钮对应locator 登录页面名称--》登录页面的所有定位器 -->Map<String,Map
 * <String,Locator>> 登录按钮名称 --》登录按钮locator --》Map
 * <String,Locator>（保存登录页面所有定位器的容器）
 * 
 * 
 * 
 * @author happy
 *
 */
public class LocatorUtils {

	/**
	 * 保存所有页面定位信息的容器：静态的、共享的，全局只有一份
	 */
	private static Map<String, Map<String, Locator>> allPagesMap = new HashMap<>();

	// 保证只解析一遍
	static {
		//获得page的路径
		String pagePath = LocatorUtils.class.getClassLoader().getResource("page").getPath();
		readFoldersXmlFile(pagePath);
	}

	/**
	 * 获取某个页面的所有的定位信息
	 * 
	 * @param pageName
	 * @return
	 */
	public static Map<String, Locator> getLocatorsByPageName(String pageName) {
		return allPagesMap.get(pageName);
	}

	/**
	 * 根据页面名称和元素名称获取对应的定位器信息
	 * 
	 * @param pageName
	 * @param locatorName
	 * @return
	 */
	public static Locator getLocatorByPageNameAndLocatorName(String pageName, String locatorName) {
		return getLocatorsByPageName(pageName).get(locatorName);
	}

	private static void readXml(String xmlFilePath) {
		SAXReader reader = new SAXReader();
		// InputStream inputStream =
		// LocatorUtils.class.getResourceAsStream("/page/page.xml");
		InputStream inputStream = null;
		Document document = null;
		try {
			inputStream = new FileInputStream(xmlFilePath);// 把xml文件加载成io输入流
			document = reader.read(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根元素就是page
		Element rootElement = document.getRootElement();
		//获取根元素的页面名称
		String pageName = rootElement.attributeValue("pageName");
		//获得根元素的所有的locator子元素
		List<Element> locatorElements = rootElement.elements();
		// 准备一个容器，保存当前页面所有的元素Locator
		Map<String, Locator> currrentPagelocatorMap = new HashMap<String, Locator>();
		// 遍历page中间的所有的元素定位器
		for (Element locatorElement : locatorElements) {
			// <locator name="手机号码输入框" type="id"
			// value="mobilephone"></locator>
			// locator的描述
			String name = locatorElement.attributeValue("name");
			// 元素的定位方式
			String type = locatorElement.attributeValue("type");
			// 元素的定位的值
			String value = locatorElement.attributeValue("value");
			Locator locator = new Locator(name, type, value);
			// 把这个locator放到locatorMap
			currrentPagelocatorMap.put(name, locator);
		}
		// 把当前页面的所有的定位信息对象放到到allPagesMap
		allPagesMap.put(pageName, currrentPagelocatorMap);
	}

	public static void main(String[] args) {
//		String pagePath = LocatorUtils.class.getClassLoader().getResource("page").getPath();
//		readFoldersXmlFile(pagePath);
		
		Locator locator = getLocatorByPageNameAndLocatorName("登录页面", "提示信息元素");
		System.out.println(locator);

	}

	/**
	 * 获取文件夹的xml文件
	 * 
	 * @param folderName
	 */
	public static void readFoldersXmlFile(String folderName) {
		File file = new File(folderName);
		// 列出这个文件夹的所有的子文件
		File[] subFiles = file.listFiles();
		for (File subFile : subFiles) {
			// 子文件的完整的路径
			String subFilePath = subFile.getAbsolutePath();
			// 如果是xml文件，直接进行解析
			if (subFile.isFile() && subFilePath.endsWith(".xml")) {
				readXml(subFilePath);
			} else {
				// 是目录文件，继续遍历--》我需要一个功能:现在有一个文件夹路径，要获取到其中的xml文件
				readFoldersXmlFile(subFilePath);// 递归调用
			}
		}
	}

}
