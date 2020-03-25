package com.lemon.web.auto.day04.section02;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
		driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
		;
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
		// 点击排课管理
		driver.findElement(By.id("class-manage")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("一周排课")).click();
		Thread.sleep(5000);
//		切换方式：
//		iframe的索引，在页面中的位置
//		driver.switchTo().frame(index)
//		iframe的name或id
//		driver.switchTo().frame(id)
//		driver.switchTo().frame(name)
//		iframe WebElement
//		driver.switchTo().frame(WebElement)
//		回到默认内容页面(否则会找不到元素)
//		driver.switchTo().defaultContent()
		WebElement iframeElement = driver.findElement(By.cssSelector("iframe[src='class-plan-list.html']"));
		//切换
		driver.switchTo().frame(iframeElement);
		
		driver.findElement(By.name("courseTitle")).sendKeys("java自动化");
		//切换为默认内容
		driver.switchTo().defaultContent();
		//点击菜单中的老师信息管理
		driver.findElement(By.id("teacher-manage")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
