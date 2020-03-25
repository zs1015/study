package com.zs.auto.day02_1012.section;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementestByCss {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com");
        // 7.cssSelect 样式选择器
        // 用tagName：直接写tagName
        // 用id：#ID值
        // 用className： .className的值
        // driver.findElement(By.cssSelector("#kw")).sendKeys("hi");
        // driver.findElement(By.cssSelector(".s_ipt")).sendKeys("hi");

        // 属性选择的方式（强大） 方括号拼接
        // driver.findElement(By.cssSelector("input[autocomplete='off']")).sendKeys("hi");
        driver.findElement(By.cssSelector("input[autocomplete='off'][class='s_ipt']")).sendKeys("hi");
        //其中一个写错会出错
        // 可以从页面上右键copy获取：#kw
        Thread.sleep(3000);
        driver.quit();
    }

}
