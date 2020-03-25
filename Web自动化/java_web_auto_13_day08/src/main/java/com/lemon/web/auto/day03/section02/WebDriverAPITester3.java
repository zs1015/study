package com.lemon.web.auto.day03.section02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverAPITester3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.switchTo()
//		此方法可以获取到TargetLocator对象，通过此对象的相关函数可以传递自动化指令到iframe或者不同的window对象
//		driver.switchTo().frame();
//		driver.switchTo().window();
//		driver.switchTo().alert();
//		...

		
		Thread.sleep(5000);
		driver.quit();
	}
}
