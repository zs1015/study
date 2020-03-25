package com.zs.auto.day05_1024.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestTime12306removeReadonly {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://www.12306.cn/index/");
        // 或者2：移除元素的只读属性 document.getElementById('train_date').removeAttribute('readonly');
        
//        String js = "document.getElementById('train_date').removeAttribute('readonly');";
//        driver.executeScript(js);
//        Thread.sleep(2000);
//        driver.findElement(By.id("train_date")).clear();
//        Thread.sleep(2000);
//        driver.findElement(By.id("train_date")).sendKeys("2019-10-25");
//        Thread.sleep(2000);
////        driver.findElement(By.id("search_one")).click();
//        
//        //滑动到最底
//        String js2 ="window.scroll(0,document.body.scrollHeight);";
//        driver.executeScript(js2);

        // jquery
        driver.get("https://www.baidu.com");
        String js3 ="$('#kw').val(\"nihao\");";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver; 
        javascriptExecutor.executeScript(js3);
        Thread.sleep(2000);
        driver.quit();
    }

}
