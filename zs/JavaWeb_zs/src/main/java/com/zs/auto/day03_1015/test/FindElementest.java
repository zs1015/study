package com.zs.auto.day03_1015.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        // driver.findElement(By.partialLinkText("新闻")).click();
        WebElement element = driver.findElement(By.id("kw"));

         element.sendKeys("你好");
        // Thread.sleep(2000);
        // element.clear();
        
        element.sendKeys(Keys.CONTROL,"a");//全选
         Thread.sleep(2000);
        element.sendKeys(Keys.CONTROL,"c");//复制
        Thread.sleep(2000);
        element.sendKeys(Keys.CONTROL,"v");//粘贴
        Thread.sleep(2000);
        element.sendKeys(Keys.CONTROL,"v");//“X”：剪切
        
        Thread.sleep(3000);
        driver.quit();
    }

}
