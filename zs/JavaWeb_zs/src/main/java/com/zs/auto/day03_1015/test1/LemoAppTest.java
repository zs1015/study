package com.zs.auto.day03_1015.test1;

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
        // (1)Thread.sleep()
        // 强制等待、硬性等待、线程等待、线程休眠
        // 缺点：无法缺点合适的等待时间，可能不生效，可能造成浪费时间
        // (2)driver.manage().timeouts().implicitlyWait(time, unit)
        // 延时等待、隐式等待--->全局设置（但并不是所有的元素都需要等待）
        // 在设置的时间里不断的查找元素，直到找到就执行or超时报错
        // 缺点1.全局设置，但并不是页面上所有元素都需要等待
        // 缺点2.隐式等待只能等待页面上（dom结构）存在的元素
        // （元素有，但不可见；元素有，但是失效状态，会超时报错）
        // 复杂的场景办不到：等待元素已经可见，等待元素可被点击，等待iframe已经加载出来
        // (3)显式等待、智能等待:WebDriverWait
        // WebDriverWait wait = new WebDriverWait(driver, 10)
        // 直到找到元素才执行后续操作
        //调用 until 或 until_not 中的方法的间隔时间，默认是0.5秒
        //2.隐式等待
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://test.lemonban.com/lmcanon_web_auto/mng/login.html");
        driver.findElement(By.id("mobilephone")).sendKeys("13888888888");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("login")).click();

         Thread.sleep(2000);// 等待一下
        // driver.findElement(By.id("class-manage")).click();// 点击排课管理--->一周排课
        // Thread.sleep(2000); // 下拉框加载慢，等待一下
        // driver.findElement(By.partialLinkText("一周排课")).click();

        driver.findElement(By.id("class-manage")).click();
        
        
        // 3.显式等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // until,,直到。。。才。。。；直到找到想要的元素才
        WebElement element = wait.until(new ExpectedCondition<WebElement>() {
            @Override
            // 传WebElemen泛型，返回
            public WebElement apply(WebDriver arg0) {// 应用
                return driver.findElement(By.partialLinkText("一周排课"));
            }
        });
        element.click();

        Thread.sleep(3000);
        driver.quit();
    }

}
