package com.lemon.web.auto.day03.section02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitTester_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//延时等待2：隐式等待 --> 全局设置、在找元素之前进行设值
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		;
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		// 点击排课管理
		driver.findElement(By.id("class-manage")).click();
		driver.findElement(By.linkText("一周排课")).click();
		/**
		 * 1:优点：相对比较灵活，不会浪费时间了
		 * 2:缺点：
		 * 		并不是页面上所有的元素都需要等待
		 * 		隐式等待只能等待页面上（dom结构）存在这个元素（元素有，但是不可见，元素有，但是是失效状态）
		 * 		复杂一点的场景是没有办法办到：等待元素已经可见，等待元素可被点击，等待iframe已经加载出来、等待窗口已经存在....
		 */
		
		driver.quit();
	}
}
