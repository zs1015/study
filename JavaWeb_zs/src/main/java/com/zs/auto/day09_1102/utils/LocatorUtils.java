package com.zs.auto.day09_1102.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zs.auto.day09_1102.pojo.Locator;

public class LocatorUtils {
    // 保存所有页面定位信息的容器(全局只有一份)：静态的、共享的，
    private static Map<String, Map<String, Locator>> allPageMap = new HashMap<>();;

    // 保证只加载xml一次
    static {
        // 获得page的路径
        String pagePath = LocatorUtils.class.getClassLoader().getResource("page").getPath();
        readFile(pagePath);
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

    private static void readXml(String xmlFilePath) {
        SAXReader reader = new SAXReader();
        // InputStream inputStream =
        // LocatorUtils.class.getResourceAsStream("/page/page.xml");
        InputStream inputStream = null;
        Document document = null;
        try {
            // 把递归找到的所有xml文件加载成io输入流
            inputStream = new FileInputStream(xmlFilePath);
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
        allPageMap.put(pageName, currrentPagelocatorMap);
    }


    public static void main(String[] args) throws Exception {
        // Map<String, Map<String, Locator>> allPageMap = readXml();
        // Locator locator = allPageMap.get("登录页面").get("登录按钮");
        // System.out.println(locator);
        Locator locator = getLocatorsByPageNameAndLocatorName("登录页面", "手机号码输入框");
        System.out.println(locator);
    }
    
    public static void readFile(String path){
        File file = new File(path);
        File[] list = file.listFiles();
        for (File subFile : list) {
            // 子文件的完整的路径
            String subFilePath = subFile.getAbsolutePath();
            // 如果是xml文件，直接进行解析
            if (subFile.isFile() && subFilePath.endsWith(".xml")) {
                //TODO 开始读取数据
                readXml(subFilePath);
            } else {
                // 是目录文件，继续遍历--》有一个文件夹路径，要获取到其中的xml文件
                // 递归调用
                readFile(subFilePath);
            }
        }
    }

}
