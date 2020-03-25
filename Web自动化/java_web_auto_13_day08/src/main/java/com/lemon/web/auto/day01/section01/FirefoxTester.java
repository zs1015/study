package com.lemon.web.auto.day01.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTester {

	// selenium2.xxx版本，Firefox驱动程序是集成在FirefoxDriver（Firefox46.0 + selenium
	// 2.53.1）
	// selenium3.xxx本本，Firefox是需要驱动程序（放到Path路径里，或者代码手动设置）
	/**
	 * 异常1：如果在PATH中找不到Firefox的可执行程序对应的路径，会报如下错误
	 * 	Cannot find firefox binary in PATH. Make sure firefox is installed.
	 * 		fix1:添加环境变量
	 * 		fix2:指定可执行文件的路径
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		//0:设置系统属性，指定firefox的可执行文件的路径
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		// 1:自动启动浏览器-->selenium提供给我们启动Firefox浏览器的类、方法
		FirefoxDriver driver = new FirefoxDriver();
		// 2:自动输入url
		driver.get("http://www.baidu.com");
		// 3:自动找到百度输入框，输入要查找的内容
		WebElement input = driver.findElement(By.id("kw"));
		// System.out.println(input.getAttribute("name"));
		// System.out.println(input.getAttribute("maxlength"));
		input.sendKeys("柠檬班软件测试");
		// 4:自动找到"百度一下"按钮，点击
		driver.findElement(By.id("su")).click();
		// 5:自动关闭浏览器
		Thread.sleep(5000);
		driver.quit();
	}

}
