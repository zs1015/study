package com.test.day02;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.tools.ant.taskdefs.Touch;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GestureTest {

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
		desiredCapabilities.setCapability("appPackage", "com.baidu.BaiduMap");
		// 4、App启动，相当于式大门，启动App
		desiredCapabilities.setCapability("appActivity", "com.baidu.baidumaps.WelcomeScreen");

		// 5、加上noReset属性 不清除掉应用的数据
		desiredCapabilities.setCapability("noReset", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);

	}

	@Test(enabled = false)
	public void doSwipe() throws InterruptedException {
		// 1、等待
		Thread.sleep(5000);
		// 2、java-client旧版本
		// driver.swipe(433, 595, 420, 1122, 500);
		swipeDown();
		Thread.sleep(2000);
	}

	@Test(enabled = false)
	public void multiSwipe() throws InterruptedException {
		// 1、等待
		Thread.sleep(5000);
		unlockSquared();
		// 2、多次滑动解锁
		// 先来确定每个解锁点的坐标
		// （185，570） （456，570） （710，570）
		// （446，828）
		// （185，1084）（456，1084）（710，1084）
		// 把全部的坐标转换成PointOption类型的
		/*
		 * PointOption pointOption1 = PointOption.point(185, 570); PointOption
		 * pointOption2 = PointOption.point(456, 570); PointOption pointOption3
		 * = PointOption.point(710, 570); PointOption pointOption4 =
		 * PointOption.point(446, 828); PointOption pointOption5 =
		 * PointOption.point(185, 1084); PointOption pointOption6 =
		 * PointOption.point(456, 1084); PointOption pointOption7 =
		 * PointOption.point(710, 1084);
		 * 
		 * // 初始化触摸动作对象 TouchAction touchAction = new TouchAction(driver);
		 * 
		 * touchAction.press(pointOption1).moveTo(pointOption2).moveTo(
		 * pointOption3).moveTo(pointOption4)
		 * .moveTo(pointOption5).moveTo(pointOption6).moveTo(pointOption7).
		 * release(); touchAction.perform();
		 */
	}

	@Test
	public void testZoom() throws InterruptedException {
		Thread.sleep(9000);
		// 1、多点触摸动作的对象
		MultiTouchAction multiTouch = new MultiTouchAction(driver);
		// 1、得到A,B,C,D点的坐标
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		int aPointx = width / 5;
		int aPointy = height / 5;

		int bPointx = width * 2 / 5;
		int bPointy = height * 2 / 5;

		int cPointx = width * 3 / 5;
		int cPointy = height * 3 / 5;

		int dPointx = width * 4 / 5;
		int dPointy = height * 4 / 5;

		// 初始化两根手指的动作
		TouchAction action1 = new TouchAction(driver);
		action1.press(PointOption.point(bPointx, bPointy)).
			moveTo(PointOption.point(aPointx, aPointy)).release();

		TouchAction action2 = new TouchAction(driver);
		action2.press(PointOption.point(cPointx, cPointy)).
			moveTo(PointOption.point(dPointx, dPointy)).release();

		multiTouch.add(action1).add(action2);
		multiTouch.perform();
		Thread.sleep(2000);
	}

	/**
	 * 通用的向下滑动方法
	 */
	public void swipeDown() {
		// 怎么获取滑动的起始点、终止点、滑动时间
		// 起始点--》屏幕宽度的1/2位置 高度 1/4位置
		int screenX = driver.manage().window().getSize().getWidth();
		int screenY = driver.manage().window().getSize().getHeight();
		int startx = screenX / 2;
		int starty = screenY / 4;
		int endx = screenX / 2;
		int endy = screenY * 3 / 4;
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

	public void unlockSquared() {
		// 1、得到九宫格解锁控件的起始x，y轴的值
		WebElement webElement = driver.findElementById("com.xxzb.fenwoo:id/lpv_password");
		Point point = webElement.getLocation();
		int x = point.getX();
		int y = point.getY();

		// 2、得到解锁控件的宽、高
		int width = webElement.getSize().getWidth();
		int height = webElement.getSize().getHeight();

		PointOption pointOption1 = PointOption.point(x + width / 6, y + height / 6);
		PointOption pointOption2 = PointOption.point(x + 3 * width / 6, y + height / 6);
		PointOption pointOption3 = PointOption.point(x + 5 * width / 6, y + height / 6);
		PointOption pointOption4 = PointOption.point(x + 3 * width / 6, y + height * 3 / 6);
		PointOption pointOption5 = PointOption.point(x + width / 6, y + height * 5 / 6);
		PointOption pointOption6 = PointOption.point(x + 3 * width / 6, y + height * 5 / 6);
		PointOption pointOption7 = PointOption.point(x + 5 * width / 6, y + height * 5 / 6);
		// 初始化触摸动作对象
		TouchAction touchAction = new TouchAction(driver);

		touchAction.press(pointOption1).moveTo(pointOption2).moveTo(pointOption3).moveTo(pointOption4)
				.moveTo(pointOption5).moveTo(pointOption6).moveTo(pointOption7).release();
		touchAction.perform();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
