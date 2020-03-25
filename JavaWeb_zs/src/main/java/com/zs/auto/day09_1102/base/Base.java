package com.zs.auto.day09_1102.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.zs.auto.day09_1102.pojo.Locator;
import com.zs.auto.day09_1102.utils.LocatorUtils;
import com.zs.auto.day09_1102.utils.PropertiesUtil;
import com.zs.auto.day09_1102.utils.WebAutoUtils;


/**
 * 基础测试类
 * 
 * @author Administrator
 *
 */
public abstract class Base {
    //子类对应的页面名称
    protected String pageName;
    //抽象方法(获取当前页面名字),需要子类去实现
    protected abstract String getCurrentPageName();
    
    // 需要写static,静态的,共享,不然会空指针
    protected static WebDriver driver = null;
    protected static WebDriverWait wait = null;
    
    public static WebDriver getDriver() {
        return driver;
    }
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
    protected WebElement getElement(Locator locator) {
        return getElement(locator, 5L);
    }
    protected WebElement getElement(String pageName,String locatorName) {
        Locator locator = LocatorUtils.getLocatorsByPageNameAndLocatorName(pageName,locatorName);
        return getElement(locator, 5L);
    }

    /**
     * 智能等待,元素出现在dom结构中 
     * @param by
     * @param timeOut
     * @return
     */
    protected WebElement getElement(By by, Long timeOut) {
        wait =new WebDriverWait(driver, timeOut);
        // 匿名内部类
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver arg0) {
                return driver.findElement(by);
            }
        });
        return element;
    }
    protected WebElement getElement(Locator locator, Long timeOut) {
        wait =new WebDriverWait(driver, timeOut);
        /*String type = locator.getType();// 定位的方式：id,name,cssSelector，xpath...
        String value = locator.getValue();// 定位的值:phone password
        // 通过type和value得到一个by对象
        By by = null;
        if ("id".equalsIgnoreCase(type)) {
            by = By.id(value);
        } else if ("name".equalsIgnoreCase(type)) {
            by = By.name(value);
        } else if ("tagName".equalsIgnoreCase(type)) {
            by = By.tagName(value);
        } else if ("linkText".equalsIgnoreCase(type)) {
            by = By.linkText(value);
        } else if ("partialLinkText".equalsIgnoreCase(type)) {
            by = By.partialLinkText(value);
        } else if ("cssSelector".equalsIgnoreCase(type)) {
            by = By.cssSelector(value);
        } else if ("className".equalsIgnoreCase(type)) {
            by = By.className(value);
        } else if ("xpath".equalsIgnoreCase(type)) {
            by = By.xpath(value);
        } else {
            throw new RuntimeException("没有这种定位方式！！！");
        }
        //赋值给一个final修饰的变量,使他可以在匿名内部类中使用
        final By by1 =by;*/
        By by = getByWithLocator(locator);
        // 匿名内部类
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver arg0) {
                return driver.findElement(by);//dom结构
            }
        });
        return element;
    }
    
    /**
     * 通过一个Locator定位器的对象,组装返回一个By对象
     * @param locator
     * @return
     */
    public By getByWithLocator(Locator locator){
        String type = locator.getType();// 定位的方式：id,name,cssSelector，xpath...
        String value = locator.getValue();// 定位的值:phone password
        // 通过type和value得到一个by对象
        By by = null;
        if ("id".equalsIgnoreCase(type)) {
            by = By.id(value);
        } else if ("name".equalsIgnoreCase(type)) {
            by = By.name(value);
        } else if ("tagName".equalsIgnoreCase(type)) {
            by = By.tagName(value);
        } else if ("linkText".equalsIgnoreCase(type)) {
            by = By.linkText(value);
        } else if ("partialLinkText".equalsIgnoreCase(type)) {
            by = By.partialLinkText(value);
        } else if ("cssSelector".equalsIgnoreCase(type)) {
            by = By.cssSelector(value);
        } else if ("className".equalsIgnoreCase(type)) {
            by = By.className(value);
        } else if ("xpath".equalsIgnoreCase(type)) {
            by = By.xpath(value);
        } else {
            throw new RuntimeException("没有这种定位方式！！！");
        }
        return by;
    }
    /**
     * 智能等待元素的文本不为空,(长度大于0)     
     * @param by
     * @return
     * toast框:当页面出现文本"登录失败!",可以用智能等待,xpath(//* test=xxx)等方式定位
     */
    protected String getElementNotnull(By by) {
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
    
    protected String getElementNotnull(String pageName ,String locatorName) {
        Locator locator = LocatorUtils.getLocatorsByPageNameAndLocatorName(pageName, locatorName);
        By by = getByWithLocator(locator);
        return getElementNotnull(by);
    }
    protected String getElementNotnull(String locatorName) {
        return getElementNotnull(getCurrentPageName(),locatorName);
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

    protected void click(Locator locator) {
        getElement(locator).click();
    }
    /**
     * 点击指定页面对应的元素
     * @param pageName 页面名字
     * @param locatorName 元素名
     */
    protected void click(String pageName, String locatorName) {
        getElement(pageName, locatorName).click();
    }
    /**
     * 点击当前页面的元素
     * @param locatorName
     */
    protected void click(String locatorName) {
        //获取了当前页面的名字
        click(getCurrentPageName(), locatorName);
    }
    /**
     * 输入
     * @param by 元素定位器(Locator)
     * @param content 要输入的内容
     */
    protected void sendKeys(By by ,String content) {
        getElement(by).sendKeys(content);
    }
    
    protected void sendKeys(Locator locator, String content) {
        getElement(locator).sendKeys(content);
    }
    
    protected void sendKeys(String pageName,String locatorName,String content) {
        getElement(pageName,locatorName).sendKeys(content);
    }

    protected void sendKeys(String locatorName, String content) {
        sendKeys(getCurrentPageName(), locatorName, content);
    }
    /**
     * 获取文本
     * @param by 元素定位器(Locator)
     * @return 
     */
    protected String getText(By by) {
        return getElement(by).getText();
    }
    protected String getText(Locator locator) {
        return getElement(locator).getText();
    }
    
    protected String getText(String pageName,String locatorName) {
        return getElement(pageName,locatorName).getText();
    }
    protected String getText(String locatorName) {
        return getText(getCurrentPageName(), locatorName);
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
        return wait.until(ExpectedConditions.urlContains(pratiaUrl));
        /*return wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl != null && currentUrl.contains(pratiaUrl)) {
                    return true;
                }
                return false;
            }
        });*/
    }
    
    
    //----------------------断言--------------------------------------
    /**
     * 断言当前页面的元素,并且和期望值是否等于
     * @param locatorName
     * @param expectedText
     */
    protected void assertElementTextEquals(String locatorName, String expectedText) {
        assertElementTextEquals(getCurrentPageName(), locatorName, expectedText);
    }
    /**
     * 断言指定页面的元素,并且和期望值是否等于
     * @param pageName 指定页面的名称
     * @param locatorName
     * @param expectedText
     */
    protected void assertElementTextEquals(String pageName,String locatorName, String expectedText) {
        String actual = getElementNotnull(pageName,locatorName);
        Assert.assertEquals(actual, expectedText);
    }
    /**
     * 断言当前页面是否包含对应的url
     * @param pratiaUrl
     */
    protected void asssertPageUrlContains(String pratiaUrl) {
        Assert.assertTrue(currentContainsPratiaUrl(pratiaUrl));
    }
    
    // assertTextPresent：断言页面元素文本值为某文本
    protected void assertTextPresent(String pageName, String locatorName, String expectedText) {
        // TODO
    }

    // assertPartialTextPresent：断言指定页面元素文本值包含某文本
    protected void assertPartialTextPresent(String pageName, String locatorName, String expectedText) {
        String actualText = getElement(pageName, locatorName).getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    // 断言指定页面元素文本值包含某文本
    protected void assertPartialTextPresent(String locatorName, String expectedText) {
        assertPartialTextPresent(getCurrentPageName(), locatorName, expectedText);
    }

    // assertElementEditable：断言某元素可编辑
    protected void assertElementEditable(String pageName, String locatorName) {
        WebElement element = getElement(pageName, locatorName);
        Assert.assertTrue(element.isEnabled());
    }

    protected void assertElementEditable(String locatorName) {
        assertElementEditable(this.getCurrentPageName(), locatorName);
    }
    // assertElementNotEditable：断言某元素不可编辑
    // assertURLContains：断言当前URL包含
    // assertTextNotPresent
    // assertTextNotPresentPrecesion
    // assertElementAttributeValueEquals
    // assertElementAttributeValueNotEquals
    // assertAlertTextContains
    
}
