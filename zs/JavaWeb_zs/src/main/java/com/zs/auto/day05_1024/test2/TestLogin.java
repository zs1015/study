package com.zs.auto.day05_1024.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestLogin {
    public static void main(String[] args) throws InterruptedException {
        String browserName ="firefox";
        WebDriver driver = WebAutoUtils.getDriver(browserName, "2.x");
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("你好");
        Thread.sleep(2000);
        driver.close();
    }

}
