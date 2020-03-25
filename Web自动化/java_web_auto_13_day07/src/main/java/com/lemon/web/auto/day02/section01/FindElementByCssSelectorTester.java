package com.lemon.web.auto.day02.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementByCssSelectorTester {

	//一定要去练习：https://blog.csdn.net/hou_angela/article/details/80519718
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		//<input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off">
//		driver.findElement(By.cssSelector("#kw")).sendKeys("柠檬班");;//样式选择器
//		driver.findElement(By.cssSelector("input#kw")).sendKeys("柠檬班666");;//样式选择器
//		driver.findElement(By.cssSelector("input.s_ipt")).sendKeys("柠檬班888");;//样式选择器
		//属性选择的方式：By.cssSelector("标签名[属性名='属性值']");
//		driver.findElement(By.cssSelector("input[autocomplete='off']")).sendKeys("柠檬班软件测试");;
//		driver.findElement(By.cssSelector("input[autocomplete='offline'][class='s_ipt']")).sendKeys("柠檬班软件测试666");;
		driver.findElement(By.cssSelector("input[autocomplete^='o'][class^='s_i']")).sendKeys("柠檬班软件测试666");;
		Thread.sleep(5000);
		
		//用工具去找：浏览器自带的开发者工具去copy就ok
		// #number-attend > div.content > div.opt.clearfix > span
		
		driver.quit();
	}
}
