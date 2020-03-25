package com.zs.auto.day03_1015.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementest3 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("http://120.78.128.25:8765/Index/login.html");
        driver.findElement(By.name("phone")).sendKeys("13422334455");
        driver.findElement(By.name("password")).sendKeys("123456");
        
//        driver.findElement(By.tagName("button")).click();
//        driver.findElement(By.className("btn-special")).submit();// 提交按钮
        driver.findElement(By.name("login-form")).submit();// 表单提交按钮
        Thread.sleep(3000);
        driver.quit();
    }

}
