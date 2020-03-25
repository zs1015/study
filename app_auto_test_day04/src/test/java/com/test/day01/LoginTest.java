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
	public void setUp() throws MalformedURLException, InterruptedException {
		// 等待
		Thread.sleep(5000);
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("我的柠檬");
		el1.click();
		MobileElement el2 = (MobileElement) driver
				.findElementById("com.lemon.lemonban:id/fragment_my_lemon_avatar_layout");
		el2.click();
	}

	@Test
	public void testLoginSuccess() throws InterruptedException {
		Thread.sleep(2000);
		MobileElement el3 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_mobile");
		el3.sendKeys("13323234545");
		MobileElement el4 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_password");
		el4.sendKeys("234545");
		MobileElement el5 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/btn_login");
		el5.click();
	}

	@Test
	public void testLoginFailure() throws InterruptedException {
		Thread.sleep(2000);
		MobileElement el3 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_mobile");
		el3.sendKeys("13323234545");
		MobileElement el4 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/et_password");
		el4.sendKeys("123456");
		MobileElement el5 = (MobileElement) driver.findElementById("com.lemon.lemonban:id/btn_login");
		el5.click();
	}

}
