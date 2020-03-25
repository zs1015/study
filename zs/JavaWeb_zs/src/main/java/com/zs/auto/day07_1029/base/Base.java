package com.zs.auto.day07_1029.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zs.auto.day06_1026.section1.utils.WebAutoUtils;
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
    protected static WebDriverWait wait = null;

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

    /**
     * 智能等待,元素出现在dom结构中 
     * @param by
     * @param timeOut
     * @return
     */
    protected WebElement getElement(By by, Long timeOut) {
        wait =new WebDriverWait(driver, 10);
        // 匿名内部类
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver arg0) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    /**
     * 智能等待元素的文本不为空,(长度大于0)     
     * @param by
     * @return
     * toast框:当页面出现文本"登录失败!",可以用智能等待,xpath(//* test=xxx)等方式定位
     */
    public String getElementNotnull(By by) {
        wait = new WebDriverWait(driver, 10);
        String elementText = wait.until(new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver arg0) {
                WebElement element = driver.findElement(by);
                String text = element.getText();
                // 如果元素不为空,且元素的文本不为空,且文本长度大于0
                if (element != null && text != null && text.length() > 0) {
                    //System.out.println("-----------");
                    //真正返回非空的是当条件都满足的时候
                    return text;
                }
                return null;
            }
        });
        return elementText;
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
        driver.get(PropertiesUtil.gerUrl(urlKey));
        /*
         * Properties properties = new Properties(); try {
         * properties.load(LoginTest.class.getResourceAsStream(
         * "/properties/test.properties"));
         * driver.get(properties.getProperty(urlKey)); } catch (IOException e) {
         * e.printStackTrace(); }
         */
    }
    
    protected String getCurrent(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getCurrentUrl();
    }
    /**
     * 也可以智能等待,获取页面url,判断是否包含pratiaUrl
     * 直到返回true,才等待结束,返回
     * @param pratiaUrl
     * @return
     */
    protected boolean currentContainsPratiaUrl(String pratiaUrl) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl != null && currentUrl.contains(pratiaUrl)) {
                    return true;
                }
                return false;
            }
        });
    }
}
