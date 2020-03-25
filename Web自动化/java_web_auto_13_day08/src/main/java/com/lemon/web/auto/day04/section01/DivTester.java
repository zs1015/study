package com.lemon.web.auto.day04.section01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DivTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://120.78.128.25:8765/");
		driver.findElement(By.partialLinkText("收益计算器")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[data-type='5']")).click();

		Thread.sleep(5000);
		driver.quit();
	}
}
