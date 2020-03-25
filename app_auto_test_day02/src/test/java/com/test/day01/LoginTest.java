package com.test.day01;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

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

    //URL地址
    //localhost:Appium的工作地址
    //4723：Appium的端口号
    //  "/wd/hub" Appium通讯节点 接口地址
    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    
    //1、和Appium建立通讯链接（remoteUrl）
    //2、把配置传给Appium
    //3、Appium根据配置去做对应的事情（找到测试的设备、找到测试的App、启动测试的App）
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    
    //做了哪些事情？？？启动了chromeDriver，并且脚本和启动通讯上，打开浏览器
    //ChromeDriver chromeDriver = new ChromeDriver();
  }

  @Test
  public void sampleTest() throws InterruptedException {
	  //等待
	  Thread.sleep(5000);
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
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
