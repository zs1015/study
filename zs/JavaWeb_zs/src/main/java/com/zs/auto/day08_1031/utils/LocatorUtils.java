package com.zs.auto.day08_1031.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zs.auto.day08_1031.pojo.Locator;

public class LocatorUtils {
    // 保存所有页面定位信息的容器(全局只有一份)：静态的、共享的，
    private static Map<String, Map<String, Locator>> allPageMap = null;

    // 保证只加载xml一次
    static {
        allPageMap = readXml();
    }

    /**
     * 获取某一个页面的所有的定位信息
     * @param pageName
     * @return
     */
    public static Map<String, Locator> getOnePageLocatorsByPageName(String pageName) {
        return allPageMap.get(pageName);
    }

    /**
     * 根据页面名称+元素名称,获取对应的定位器信息
     * @param pageName
     * @return
     */
    public static Locator getLocatorsByPageNameAndLocatorName(String pageName, String locatorName) {
        return allPageMap.get(pageName).get(locatorName);
    }

    private static Map<String, Map<String, Locator>> readXml() {
        SAXReader reader = new SAXReader();
        InputStream inputStream = LocatorUtils.class.getResourceAsStream("/page/page.xml");
        Document document = null;
        try {
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 获取根元素
        Element rootElement = document.getRootElement();
        // 准备一个容器,存放所有页面的定位信息
        Map<String, Map<String, Locator>> allPageMap = new HashMap<String, Map<String, Locator>>();
        // 获取下边所有的叫"page"的子元素
        List<Element> pageElements = rootElement.elements("page");
        for (Element pageElement : pageElements) {
            // 获取pag元素中的pageName值
            String pageName = pageElement.attributeValue("pageName");
            // System.out.println(pageName);
            // 再准备一个容器,存当前页面的所有定位信息
            Map<String, Locator> currentPageLocatorMap = new HashMap<String, Locator>();
            // 获取元素定位器locator
            List<Element> loactorElements = pageElement.elements();
            for (Element loactorElement : loactorElements) {
                // 元素的描述
                String name = loactorElement.attributeValue("name");
                // 元素的定位方式
                String type = loactorElement.attributeValue("type");
                // 元素定位的值
                String value = loactorElement.attributeValue("value");
                // System.out.println(locatorName+" "+ locatorType+"
                // "+locatorValue);
                Locator locator = new Locator(name, type, value);
                // System.out.println(locator);
                // 把这个locator放在容器map中
                currentPageLocatorMap.put(name, locator);
            }
            // 把当前的locator定位信息放在上边的allPageMap
            allPageMap.put(pageName, currentPageLocatorMap);
        }
        return allPageMap;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Map<String, Locator>> allPageMap = readXml();
        Locator locator = allPageMap.get("登录页面").get("登录按钮");
        System.out.println(locator);
    }

}
