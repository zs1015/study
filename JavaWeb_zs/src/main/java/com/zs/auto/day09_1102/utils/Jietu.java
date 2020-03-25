/**
 * 
 */
package com.zs.auto.day09_1102.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jietu {
    @Test
    public void test1() throws InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        WebElement findElement = driver.findElement(By.id("kw"));
        boolean displayed = findElement.isDisplayed();
        System.out.println(displayed);
        Assert.assertTrue(!displayed);
        Thread.sleep(3000);
        driver.quit();
    }
}
