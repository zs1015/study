package com.lemon.web.auto.day02.section02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://120.78.128.25:8765/Index/login.html");
		//1：以绝对路径  /html/body/div[2]/div/form/div[5]/button
//		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[5]/button"));
//		System.out.println(element.getAttribute("class"));
//		System.out.println(element.getText());
		//绝对路径的驱动：因为页面可能会经常变化，就会导致dom结构会发生变化，从而导致我们之前的写到的脚本没办法正确执行
		
		//2:相对路径：
//		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("13888888888");
//		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("13666666666");
//		driver.findElement(By.xpath("//form/div[1]/input")).sendKeys("13888888888");
		//<input type="text" name="phone" placeholder="手机号" datatype="m" nullmsg="请输入手机号" errormsg="请输入正确的手机号" class="form-control username Validform_error" value="">
		// 相对路径： //*[contains(@name,'hon')]
//		driver.findElement(By.xpath("//*[contains(@name,'hon')]")).sendKeys("13666666666");
//		driver.findElement(By.xpath("//*[text()='免费注册']")).click();//有空格就报错，因为这是完整的匹配的匹配方式
//		driver.findElement(By.xpath("//*[contains(text(),'费注')]")).click();
		
		//麻烦：
		
		Thread.sleep(5000);
		driver.quit();
	}
}
