package com.zs.auto.day01_1010.section;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    public static void main(String[] args) throws InterruptedException {
        // System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Firefox69\\firefox.exe");// 火狐69.02
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("你好");
        driver.findElement(By.id("su")).click();
        Thread.sleep(7000);
        driver.quit();
    }

    /**
     * 1.The path to the driver executable must be set by the
     * webdriver.chrome.driver system property; for more information, see
     * https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver 解决方法1：配置到path中
     * 解决方法2：给个驱动
     */
}
