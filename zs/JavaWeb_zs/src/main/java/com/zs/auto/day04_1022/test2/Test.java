package com.zs.auto.day04_1022.test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        // WebDriverWait wait = new WebDriverWait(driver, 10)
        driver.manage().window().maximize();
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);// 等待一下
        driver.findElement(By.id("class-manage")).click();
        // 3.显式等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("一周排课")));
        element.click();
        // 会报错，因为是内联框架iframe，是另外一个页面了
        // 解决方案：需要切换到iframe页面里
        // driver.findElement(By.name("courseTitle")).sendKeys("java");// 报错
        Thread.sleep(3000);

        WebElement findElement = driver.findElement(By.cssSelector("iframe[src='class-plan-list.html']"));
        // id,name , index;;;; WebElement
        driver.switchTo().frame(findElement);
        driver.findElement(By.name("courseTitle")).sendKeys("java");
        Thread.sleep(3000);

        // 切回去默认内容（页面）
        driver.switchTo().defaultContent();
        driver.findElement(By.id("teacher-manage")).click();//点击老师信息管理
        Thread.sleep(3000);
        driver.quit();
    }

}
