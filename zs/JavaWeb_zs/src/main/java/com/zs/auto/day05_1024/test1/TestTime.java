package com.zs.auto.day05_1024.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTime {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);// 等待一下
        driver.findElement(By.id("class-manage")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("一周排课")));
        element.click();
        Thread.sleep(3000);

        WebElement iframeWindow = driver.findElement(By.cssSelector("iframe[src='class-plan-list.html']"));
        // id,name , index;;;; WebElement
        driver.switchTo().frame(iframeWindow);

        // 时间控件：可输入的直接用sendKeys，不过需要格式正确
        // 或者2：取出元素的属性 document.getElementById('train_date').removrArribute('readonly');
        driver.findElement(By.id("datemin")).sendKeys("2019-10-25 22:57:05");
        Thread.sleep(3000);
        driver.findElement(By.id("searchButton")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}
