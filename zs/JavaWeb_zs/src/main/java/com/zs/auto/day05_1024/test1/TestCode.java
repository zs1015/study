package com.zs.auto.day05_1024.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCode {
    /**
     * 验证码：
     * 1.（推荐）开发写死，但是预生产和生产环境的客户猜不到，不可以
     * 2.开发去掉，但是预生产和生产环境，不可以
     * 3.识别，利用图像识别技术识别（1.12306哪个是茅台，等等；2.识别有误差；3.不具备通用性）
     * 4.（推荐）cookie绕过（推荐）  addCookie()方法
     *  <1>前程贷验证码&&短信验证码：hapi
     *  <2>柠檬班题库后台：：LM19        
     * @param args
     * @throws InterruptedException
     */
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
