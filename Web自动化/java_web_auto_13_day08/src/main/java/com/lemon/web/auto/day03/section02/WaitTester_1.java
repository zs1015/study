package com.lemon.web.auto.day03.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitTester_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		;
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		// 元素还没有加载出来！！
		// 延时等待1：线程等待、硬性等待、线程休眠、强制等待
		// 我先等2秒，让浏览器先飞一会
		Thread.sleep(2000);
		// 点击排课管理
		driver.findElement(By.id("class-manage")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("一周排课")).click();
		Thread.sleep(5000);
		//缺点：我们没法确定合适的等待时间，可能不生效，可能会造成时间的浪费
		driver.quit();
	}
}
