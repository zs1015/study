package com.test.day01;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementLocate {

  private AndroidDriver driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
	 //前置准备工作
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    //这四个配置必不可少
    //1、deviceName：选择哪一台设备进行测试
    desiredCapabilities.setCapability("deviceName", "emulator-5554");
    //2、因为Appium同时支持android&ios，需要指明测试哪一个
    desiredCapabilities.setCapability("platformName", "Android");
    //3、测试App包名，选择哪一个APP进行测试
    desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
    //4、App启动，相当于式大门，启动App
    desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");
    
    //5、加入支持uiautoamtor2引擎的配置
    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
    
    //6、noReset参数，不清除掉的应用的数据  
    desiredCapabilities.setCapability("noReset", true);
    
    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    //隐式等待
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

  }

  @Test(enabled=false)
  public void sampleTest() throws InterruptedException {
	  //等待
	  Thread.sleep(5000);
	  //通过text属性去找元素(java-client版本的坑 )
	  //driver.findElement(By.name("柠檬社区")).click(); 失效
	  // 这个API是调用android系统底层的uiautomator框架去实现text属性定位的
	  //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"柠檬社区\")").click();
	  //xpath定位到柠檬社区
	  //driver.findElement(By.xpath("//android.widget.TextView[@text='柠檬社区']")).click();
	  //通过accessbility id定位属性是content-desc的
	  //driver.findElementByAccessibilityId("题库").click();
	  //坐标定位“我的柠檬”750 1530
	  //1、创建TouchAction对象 --触摸相关的动作
	  //TouchAction touchAction = new TouchAction(driver);
	  //2、把原始的x、y轴的坐标转换成pointOption类型
	  //PointOption pointOption = PointOption.point(750, 1530);
	  //3、实施点击 开始你的表演
	  //touchAction.press(pointOption).release().perform();
	  //根据屏幕的尺寸/分辨率做适配？？？
	  
	  //uiautomator元素定位
	  //1、定位到题库元素，并且点击
	  driver.findElementByAndroidUIAutomator("new UiSelector().description(\"题库\")").click();
	  
	  //2、点击去登陆按钮
	  driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.lemon.lemonban:id/button_go_login\")").click();
	  
	  //3、
  }
  
  @Test(enabled=false)
  public void loginSuccess() throws InterruptedException{
	    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("我的柠檬");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/fragment_my_lemon_avatar_layout");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_mobile");
	    el3.sendKeys("13323234545");
	    MobileElement el4 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_password");
	    el4.sendKeys("123456");
	    MobileElement el5 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/btn_login");
	    el5.click();
	    
	    //获取到toast信息（一般来做断言）
	    WebElement webElement = driver.findElement(By.xpath("//*[contains(@text,'账号信息')]"));
	    System.out.println(webElement.getText());
  }
  
  @Test
  public void testListElement(){
	  //1、点击题库
	  driver.findElementByAndroidUIAutomator("new UiSelector().text(\"题库\")").click();
	  //2、查找元素逻辑思维题-需要滑动
	  //driver.findElementByAndroidUIAutomator("new UiSelector().text(\"逻辑思维题\")").click();
	  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()."
	  		+ "scrollable(true).instance(0))."
	  		+ "scrollIntoView(new UiSelector().textMatches(\"逻辑思维题\").instance(0))").click();
	  //自定义方法
  }
	

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
