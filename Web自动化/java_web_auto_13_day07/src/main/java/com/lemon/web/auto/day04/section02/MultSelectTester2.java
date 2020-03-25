package com.lemon.web.auto.day04.section02;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MultSelectTester2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.12306.cn/index/");
		
		//移除只读属性
		String js = "document.getElementById('train_date').removeAttribute('readonly');";
		driver.executeScript(js);
		
		Thread.sleep(2000);
		driver.findElement(By.id("train_date")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("train_date")).sendKeys("2019-10-25");
		
		Thread.sleep(5000);
		driver.quit();
	}
}
