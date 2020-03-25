package com.test.day03;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HybridTest {

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
    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testHybrid() throws InterruptedException{
	  //1、点击全程班的链接（通过text文本值定位）
	  driver.findElementByAndroidUIAutomator("new UiSelector().text(\"全程班\")").click();
	  //2、进入到web页面
	  //用来获取当前所有的contexts 页面状态
	  Set<String> contexts = driver.getContextHandles();
	  System.out.println(contexts);
	  //3、切换context
	  driver.context("WEBVIEW_com.lemon.lemonban");
	  //4、定位web页面的元素信息（模式等同于web自动化模式）
	  //点击立即购买
	  driver.findElement(By.xpath("//button[text()=\"立即购买\"]")).click();
	  //在登录页面的QQ号码输入框输入QQ号
	  driver.findElement(By.xpath("//*[@id=\"u\"]")).sendKeys("1425301899");
	  //在登录页面的密码输入框输入密码
	  driver.findElement(By.xpath("//*[@id=\"p\"]")).sendKeys("123456");
	  //点击登录按钮
	  driver.findElement(By.xpath("//*[@id=\"go\"]")).click();
	  
	  //断言自行补充
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
