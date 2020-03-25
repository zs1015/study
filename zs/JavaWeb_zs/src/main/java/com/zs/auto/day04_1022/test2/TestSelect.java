package com.zs.auto.day04_1022.test2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSelect {
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

        // 单选下拉框
        // driver.findElement(By.cssSelector("option[value='1272']")).click();//写死的，所以可以直接找到,不建议使用
        // 使用封装好的select对象
        WebElement sWebElement = driver.findElement(By.name("teacher"));
        Select select = new Select(sWebElement);// 获取一个select对象
        List<WebElement> options = select.getOptions();// 获取所有的选项
        for (WebElement option : options) {
            System.out.println(option.getAttribute("value") + "," + option.getText());
        }
        // select.selectByIndex(arg0);// 根据索引选中
        // select.selectByValue(arg0);// 根据value值选中
        // select.selectByVisibleText(arg0);;// 根据外边显示的文本值选中

        // select.isMultiple();// 是否为多选

        Thread.sleep(3000);
        driver.quit();
    }

}
