package com.zs.auto.day01_1010.section;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IETest {
    // exception1：The path to the driver executable must be set by the
    // webdriver.ie.driver system property;
    // exception2:Unexpected error launching Internet Explorer. Browser zoom
    // level was set to 150%. It should be set to 100%
    // 1:把缩放级别设置到100% 2：忽略缩放级别的
    // exception3：Unexpected error launching Internet Explorer. Protected Mode
    // settings are not the same for all zones. Enable Protected Mode must be
    // set to the same value (enabled or disabled) for all zones.
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
        // 设置一个期望能力（创建一个期望能力的对象，打开浏览器前设置    ）
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //InternetExplorerDriver  ：：：IE浏览器驱动类
//        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);//忽略缩放级别
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);//忽略安全域设置
//        capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");//忽略

        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("你好");
        driver.findElement(By.id("su")).click();
        Thread.sleep(5000);
        driver.quit();// 关闭浏览器
    }

}
