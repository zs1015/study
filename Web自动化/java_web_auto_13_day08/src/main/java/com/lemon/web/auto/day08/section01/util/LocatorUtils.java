package com.lemon.web.auto.day08.section01.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;

import com.lemon.web.auto.day08.section01.pojo.Locator;

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
	private static Map<String, Map<String, Locator>> allPagesMap;

	// 保证只加载xml一遍
	static {
		allPagesMap = readXml();
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

	public static void main(String[] args) throws DocumentException {
		Map<String, Map<String, Locator>> allPagesMap = readXml();
		// 找到登录页面的登录按钮
		Locator locator = allPagesMap.get("登录页面").get("登录按钮");
		System.out.println(locator);

	}

	private static Map<String, Map<String, Locator>> readXml() {
		SAXReader reader = new SAXReader();
		InputStream inputStream = LocatorUtils.class.getResourceAsStream("/page/page.xml");
		Document document = null;
		try {
			document = reader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		List<Element> pageElements = rootElement.elements("page");
		// 准备一个容器，存放所有页面的定位信息
		Map<String, Map<String, Locator>> allPagesMap = new HashMap<String, Map<String, Locator>>();
		// 遍历所有的页面
		for (Element pageElement : pageElements) {
			// 获取pageName
			String pageName = pageElement.attributeValue("pageName");
			List<Element> locatorElements = pageElement.elements();
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

		return allPagesMap;
	}

}
