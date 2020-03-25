package com.lemon.web.auto.day03.section01;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverAPITester {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get(String url)：访问指定url页面
		driver.get("http://www.baidu.com");
		// driver.get("http://120.78.128.25:8765/loan/finance.html");
		// driver.getCurrentUrl():获取当前页面的url地址
		// System.out.println(driver.getCurrentUrl());//某一些功能测试用例执行时，做断言
		// 注册成功之后跳转到登录页面:http://xxx/login.html

		// driver.getTitle():获取当前页面的标题
		// System.out.println(driver.getTitle());
		// driver.getPageSource()：获取当前页面源代码
		// System.out.println(driver.getPageSource());//做爬虫！！！通过一些html解析库

		// driver.quit()：关闭驱动对象以及所有相关的窗口
		// driver.close()：关闭当前窗口
		// driver.findElement(By.partialLinkText("京公网安备11000002000001号")).click();
		// Thread.sleep(2000);
		// driver.close();

		// driver.findElement(by)：根据by对象获取单个元素

		// driver.findElements(by)：根据by对象获取元素集合 : 分页查询：一页显示5条
		// System.out.println(driver.findElements(By.className("invest-unit")).size());

		// 窗口句柄：窗口的id，唯一标识符
		System.out.println("打开前的窗口句柄" + driver.getWindowHandle());
		driver.findElement(By.partialLinkText("京公网安备11000002000001号")).click();
		System.out.println("打开后的窗口句柄" + driver.getWindowHandle());

		// driver.getWindowHandle()：返回当前页面句柄
		// driver.getWindowHandles()：返回所有由驱动对象打开页面的句柄，页面不同，句柄不一样
		System.out.println("------------------------------------------");
		//https://blog.csdn.net/qq3401247010/article/details/81585404
		Set<String> handleSet = driver.getWindowHandles();//得到的是有序的LinkedHashSet对象
		for (String handle : handleSet) {
			System.out.println(handle);
		}

		Thread.sleep(5000);
		driver.quit();
	}
}
