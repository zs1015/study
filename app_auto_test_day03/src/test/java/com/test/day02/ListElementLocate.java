package com.test.day02;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ListElementLocate {

	private AndroidDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// 前置准备工作
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// 这四个配置必不可少
		// 1、deviceName：选择哪一台设备进行测试
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		// 2、因为Appium同时支持android&ios，需要指明测试哪一个
		desiredCapabilities.setCapability("platformName", "Android");
		// 3、测试App包名，选择哪一个APP进行测试
		desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
		// 4、App启动，相当于式大门，启动App
		desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");

		// 5、noReset属性
		desiredCapabilities.setCapability("noReset", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	@Test
	public void testListElement() throws InterruptedException {
		Thread.sleep(3000);
		// 1、点击题库
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"题库\")").click();

		String pageSource = "";
		// 2、滑动找元素
		// 当滑动到底部的时候也找不到元素，终止循环
		while (true) {
			// 每间隔滑动一次
			pageSource = driver.getPageSource();
			if (pageSource.contains("綦枫")) {
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\"綦枫\")").click();
				break;
			}
			swipeUp();
			String newPageSource = driver.getPageSource();
			// 页面滑动之后没有任何变化--滑动到了底部
			if (newPageSource.equals(pageSource)) {
				break;
			}
		}

	}

	/**
	 * 封装的通用在列表中找元素的方法
	 */
	public void findElementByList(String text) {
		String pageSource = "";
		// 滑动找元素
		// 当滑动到底部的时候也找不到元素，终止循环
		while (true) {
			// 每间隔滑动一次
			pageSource = driver.getPageSource();
			if (pageSource.contains(text)) {
				driver.findElementByAndroidUIAutomator("new UiSelector().text("+text+")").click();
				break;
			}
			swipeUp();
			String newPageSource = driver.getPageSource();
			// 页面滑动之后没有任何变化--滑动到了底部
			if (newPageSource.equals(pageSource)) {
				break;
			}
		}
	}

	/**
	 * 通用的向上滑动方法
	 */
	public void swipeUp() {
		// 怎么获取滑动的起始点、终止点、滑动时间
		// 起始点--》屏幕宽度的1/2位置 高度 1/4位置
		int screenX = driver.manage().window().getSize().getWidth();
		int screenY = driver.manage().window().getSize().getHeight();
		int startx = screenX / 2;
		int starty = screenY * 3 / 4;
		int endx = screenX / 2;
		int endy = screenY / 4;
		int duration = 500;

		// 把原始的坐标转换成PointOption类型
		PointOption startPoint = PointOption.point(startx, starty);
		PointOption endPoint = PointOption.point(endx, endy);

		// 把时间转换成WaitOptions类型(二次转换)
		WaitOptions waitOptions = WaitOptions.waitOptions(Duration.ofMillis(500));
		// 1、初始化触摸动作对象
		TouchAction touchAction = new TouchAction(driver);
		// appium converts press-wait-moveto-release to a swipe action
		touchAction.press(startPoint).waitAction(waitOptions).moveTo(endPoint).release();
		touchAction.perform();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
