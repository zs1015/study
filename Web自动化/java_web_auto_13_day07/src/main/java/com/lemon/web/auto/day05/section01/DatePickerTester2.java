package com.lemon.web.auto.day05.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTester2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		;
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		Thread.sleep(1000);
		// 点击排课管理
		driver.findElement(By.id("class-manage")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("一周排课")).click();
		Thread.sleep(1000);
		WebElement iframeElement = driver.findElement(By.cssSelector("iframe[src='class-plan-list.html']"));
		//切换
		driver.switchTo().frame(iframeElement);
		//日期控件
		//日期是可以输入的话，直接用sendkeys，注意一下时间格式要是正确
		driver.findElement(By.id("datemin")).sendKeys("2019-10-24 20:13:33");
		
		driver.findElement(By.id("searchButton")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
