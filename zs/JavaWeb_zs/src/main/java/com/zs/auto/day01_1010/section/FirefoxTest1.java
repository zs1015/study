package com.zs.auto.day01_1010.section;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest1 {

    public static void main(String[] args) throws InterruptedException {
        // WebDriver driver = new FirefoxDriver();
        // 0:设置系统属性，指定firefox的可执行文件的路径
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Firefox69\\firefox.exe");// 火狐69.02
        // 0:设置系统属性，指定驱动
        System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
        // 1 启动浏览器
        FirefoxDriver driver = new FirefoxDriver();
        // 2.输入网址
        driver.get("https://www.baidu.com");
        // 3.找到元素，输入搜索内容
        driver.findElement(By.id("kw")).sendKeys("你好");
        // 4.点击搜索按钮
        driver.findElement(By.id("su")).click();
        // 5.等待网络等延时加载
        Thread.sleep(7000);
        // 6.关闭浏览器，关闭驱动进程
        driver.quit();
    }

}
