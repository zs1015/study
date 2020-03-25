package com.zs.auto.day04_1022.test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LemoAppTest {
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
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // // until,,直到。。。才。。。；直到找到想要的元素才
        // WebElement element = wait.until(new ExpectedCondition<WebElement>() {
        // @Override
        // // 传WebElemen泛型，返回
        // public WebElement apply(WebDriver arg0) {// 应用
        // return driver.findElement(By.partialLinkText("一周排课"));
        // }
        // });
        // element.click();

        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean element = wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {// 应用
                // 当页面显示这个元素的时候
                return driver.findElement(By.partialLinkText("一周排课")).isDisplayed();
            }
        });*/
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean element = wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {// 应用
                // 当这个元素有效的时候
                return driver.findElement(By.partialLinkText("一周排课")).isEnabled();
            }
        });*/
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean element = wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {// 应用
                // 当id=aaa的值为“haha”的时候（期望值，可以做断言）
                return driver.findElement(By.id("aaa")).equals("haha");
            }
        });
        System.out.println(element);
        Thread.sleep(3000);
        driver.quit();
    }

}
