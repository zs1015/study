package com.zs.auto.day04_1022.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DivTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://120.78.128.25:8765");
        driver.findElement(By.partialLinkText("收益计算")).click();
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[data-type='5']")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}
