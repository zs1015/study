package com.lemon.web.auto.day03.section02;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class WebDriverAPITester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// driver.manage()
		// 此方法可以获取Options--浏览器菜单操作对象,如完成浏览器的cookie设置
		//绕过验证码
//		driver.get("http://120.78.128.25:8765");
//		Options options = driver.manage();
		//fengwoo  j3o69069skei6m3cpa6p2i3rk4
		//remember_me  13825161923
//		options.addCookie(new Cookie("fengwoo", "j3o69069skei6m3cpa6p2i3rk4"));
//		options.addCookie(new Cookie("remember_me", "13825161923"));
//		driver.get("http://120.78.128.25:8765/Member/index.html");
		
		// driver.manage().timeouts()
		// 此方法可以获取TimeOuts--驱动超时对象，可进行多种场景的等待超时设置
//		driver.manage().timeouts().implicitlyWait(time, unit)//隐式等待
		Thread.sleep(5000);
		driver.quit();
	}
}
