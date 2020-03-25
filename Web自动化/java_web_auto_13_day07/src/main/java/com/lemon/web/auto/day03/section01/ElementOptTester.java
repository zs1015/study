package com.lemon.web.auto.day03.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementOptTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		
//		WebElement element = driver.findElement(By.partialLinkText("新闻"));
//		element.click();
		
//		driver.findElement(By.id("kw")).sendKeys("柠檬班");
//		Thread.sleep(2000);
//		driver.findElement(By.id("kw")).clear();
	
//		driver.findElement(By.id("kw")).sendKeys("柠檬班 ");
//		driver.findElement(By.id("kw")).sendKeys("Hello ");
		WebElement input = driver.findElement(By.id("kw"));
		input.sendKeys("柠檬班");
		Thread.sleep(2000);
		input.sendKeys(Keys.CONTROL,"a");
		Thread.sleep(2000);
		input.sendKeys(Keys.CONTROL,"x");
		Thread.sleep(2000);
		input.sendKeys(Keys.CONTROL,"v");
		Thread.sleep(2000);
		input.sendKeys(Keys.CONTROL,"v");
		Thread.sleep(2000);
		input.sendKeys(Keys.CONTROL,"v");
		
		Thread.sleep(5000);
		driver.quit();
	}
}



















