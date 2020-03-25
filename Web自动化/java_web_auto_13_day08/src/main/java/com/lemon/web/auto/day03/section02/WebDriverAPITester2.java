package com.lemon.web.auto.day03.section02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverAPITester2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 此方法可以获取Window--当前窗口对象，可进行窗口大小设置
		driver.get("http://www.baidu.com");
		// 获取window对象
		// Window window = driver.manage().window();
		Window window = driver.manage().window();
		// 窗口最大化
		// maximize()
//		driver.manage().window().maximize(); //这句用的最多的，经常在测试用例执行最前面加这一句
		// 窗口位置
		// getPosition()
		Point point = window.getPosition();
//		System.out.println(point.getX());
//		System.out.println(point.getY());
		// 窗口大小
		// getSize()
		Dimension dimension = window.getSize();
//		System.out.println(dimension.getHeight());
//		System.out.println(dimension.getWidth());
		// 设置位置
		// setPosition(targetPosition)
		window.setPosition(new Point(100, 100));
		// 设置窗口大小
		// setSize(targetSize)
		window.setSize(new Dimension(200, 600));
		
		Thread.sleep(5000);
		driver.quit();
	}
}
