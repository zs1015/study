package com.zs.auto.day06_1026.section2.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zs.auto.day06_1026.section1.utils.WebAutoUtils;
import com.zs.auto.day06_1026.section2.login.LoginTest;
import com.zs.auto.day06_1026.section2.utils.PropertiesUtil;

/**
 * 基础测试类
 * 
 * @author Administrator
 *
 */
public class Base1 {
    // 需要写static,静态的,共享,不然会空指针
    protected static WebDriver driver = null;

    @BeforeSuite
    public void beforeSuite() {
        // 执行用例前,先创建driver
        String browserName = "Chrome";
        driver = WebAutoUtils.getDriver(browserName, "2.x");
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    
    
    // 提供简单的方法输入内容
    // 提供简单的方法点击
    // 提供简单的方法获取文本
    /**
     * 点击元素
     * @param by 元素定位器(Locator)
     */
    protected void click(By by) {
        driver.findElement(by).click();
    }
    /**
     * 输入
     * @param by 元素定位器(Locator)
     * @param content 要输入的内容
     */
    protected void sendKeys(By by ,String content) {
        driver.findElement(by).sendKeys(content);
    }
    /**
     * 获取文本
     * @param by 元素定位器(Locator)
     * @return 
     */
    protected String getText(By by) {
        return driver.findElement(by).getText();
    }
    /**
     * 去哪个url:::::这样会每来一个创建一个,浪费资源,提到static块中
     * @param urlKey   url的key值(在配置文件中)
     */
    protected void to(String urlKey) {
        /*
         * Properties properties = new Properties(); try {
         * properties.load(LoginTest.class.getResourceAsStream(
         * "/properties/test.properties"));
         * driver.get(properties.getProperty(urlKey)); } catch (IOException e) {
         * e.printStackTrace(); }
         */
        driver.get(PropertiesUtil.gerUrl(urlKey));
    }
}
