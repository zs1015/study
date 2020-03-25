package com.lemon.web.auto.day02.section01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementTester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
//		driver.get("http://120.78.128.25:8765/Index/login.html");
		//找到搜索框
		/**
		 * 查找元素用得最多的两个方法：
		 * 1：findElement 找单个元素  -->webElement
		 * 2：findElements 找多个元素 -->List<WebElements>
		 */
		
		//<input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off">
		//1:id，唯一的标识符，相当于人的身份证(如果元素有id属性，就直接用id属性去找，可以去要求前端开发人员对于重要功能对应的元素加上唯一id属性)
//		WebElement element = driver.findElement(By.id("kw"));
		//2:name：姓名
//		WebElement element = driver.findElement(By.name("wd"));
//		System.out.println(element.getAttribute("autocomplete"));
		//如果要把相同name值的元素全部找出来--》容器
//		List<WebElement> elements = driver.findElements(By.name("wd"));
//		System.out.println(elements.get(0).getAttribute("autocomplete"));
		//3:tagName 标签  ，找出街上性别为男生
//		WebElement element = driver.findElement(By.tagName("a"));
//		System.out.println(element.getAttribute("href"));
		//selenium--》爬虫！！！
//		List<WebElement> elements = driver.findElements(By.tagName("a"));
//		for (WebElement webElement : elements) {
//			System.out.println(webElement.getAttribute("href"));
//		}
		
		//4:className 样式名 ：找穿红色衣服的人，黑色裤子的人
//		WebElement element = driver.findElement(By.className("s_ipt"));
//		element.sendKeys("柠檬班软件测试");
		
//		<input type="submit" id="su" value="百度一下" class="bg s_btn">
//		WebElement element = driver.findElement(By.className("bg s_btn"));//报错，是单个样式
//		WebElement element = driver.findElement(By.className("s_btn"));
		//invalid selector: Compound class names not permitted
//		System.out.println(element.getAttribute("value"));
		
		//5：linkText 完整的超链接文本
		//<a href="https://www.hao123.com" name="tj_trhao123" class="mnav">hao123</a>
//		WebElement element = driver.findElement(By.linkText("hao123"));
//		element.click();
		//6：partialLinkText 部分超链接文本
//		WebElement element = driver.findElement(By.partialLinkText("见反"));
//		element.click();
		
		//注意超链接的空格
//		<a href="/Index/reg.html">&nbsp;免费注册</a>
//		WebElement element = driver.findElement(By.linkText("免费注册"));
//		element.click();
		
//		WebElement element = driver.findElement(By.partialLinkText("免费注册"));
//		element.click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}



















