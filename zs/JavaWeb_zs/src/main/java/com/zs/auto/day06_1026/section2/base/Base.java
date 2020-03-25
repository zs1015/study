package com.zs.auto.day06_1026.section2.base;

import java.io.IOException;
import java.util.Properties;

import org.apache.bcel.ExceptionConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
public class Base {
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
    /**
     * 
     * @param by
     * @return
     */
    protected WebElement getElement(By by) {
        return getElement(by, 5L);
    }

    // 可以加等待
    protected WebElement getElement(By by, Long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 匿名内部类
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver arg0) {
                return driver.findElement(by);
            }
        });
        return element;
    }
   
    protected WebElement getElementToBeClickAble(By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    // 提供简单的方法输入内容
    // 提供简单的方法点击
    // 提供简单的方法获取文本
    /**
     * 点击元素
     * @param by 元素定位器(Locator)
     */
    protected void click(By by) {
        getElement(by).click();
    }
    /**
     * 输入
     * @param by 元素定位器(Locator)
     * @param content 要输入的内容
     */
    protected void sendKeys(By by ,String content) {
        getElement(by).sendKeys(content);
    }
    /**
     * 获取文本
     * @param by 元素定位器(Locator)
     * @return 
     */
    protected String getText(By by) {
        return getElement(by).getText();
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
