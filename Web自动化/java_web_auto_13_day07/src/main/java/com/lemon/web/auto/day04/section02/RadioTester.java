package com.lemon.web.auto.day04.section02;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioTester {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/svn-lemon/%E6%95%99%E5%AD%A6ppt/happy/java%E8%87%AA%E5%8A%A8%E5%8C%96/04-web%E8%87%AA%E5%8A%A8%E5%8C%96/%E7%89%B9%E6%AE%8A%E5%85%83%E7%B4%A0%E5%AE%9A%E4%BD%8D%E5%92%8C%E6%93%8D%E4%BD%9C%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/%E5%8D%95%E9%80%89%E5%A4%9A%E9%80%89%E6%A1%86/radio.html");
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.name("sex"));
		//点击第二个单选按钮
		elements.get(1).click();
		
		for (WebElement webElement : elements) {
			System.out.println(webElement.isSelected());
		}

		Thread.sleep(5000);
		driver.quit();
	}
}
