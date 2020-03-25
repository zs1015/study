package com.lemon.web.auto.day04.section01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"file:///E:/svn-lemon/%E6%95%99%E5%AD%A6ppt/happy/java%E8%87%AA%E5%8A%A8%E5%8C%96/04-web%E8%87%AA%E5%8A%A8%E5%8C%96/%E7%89%B9%E6%AE%8A%E5%85%83%E7%B4%A0%E5%AE%9A%E4%BD%8D%E5%92%8C%E6%93%8D%E4%BD%9C%E9%9D%99%E6%80%81%E9%A1%B5%E9%9D%A2/%E6%A8%A1%E6%80%81%E6%A1%86/confirm.html");

		driver.findElement(By.id("abtn")).click();

		// 得到alert框
		Alert alert = driver.switchTo().alert();
		// 常用api
		// alert.getText(); 获取警告框中的提示信息
		System.out.println(alert.getText());
		// alert.accept(); 点击确认按钮
		Thread.sleep(2000);
//		alert.accept();//点确认
		// alert.dismiss();点击取消取消
		alert.dismiss();//点取消

		Thread.sleep(5000);
		driver.quit();
	}
}
