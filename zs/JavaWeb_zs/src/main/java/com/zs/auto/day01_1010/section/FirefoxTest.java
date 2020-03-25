package com.zs.auto.day01_1010.section;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

    // selenium2.xxx版本，Firefox驱动程序是集成在FirefoxDriver（Firefox46.0 + selenium
    // 2.53.1）
    // selenium3.xxx本本，Firefox是需要驱动程序（放到Path路径里，或者代码手动设置）
    /**
     * 异常1：如果在PATH中找不到Firefox的可执行程序对应的路径，会报如下错误 Cannot find firefox binary in
     * PATH. Make sure firefox is installed. 修改方法1:添加环境变量 修改方法2:指定可执行文件的路径
     * System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
     */
    public static void main(String[] args) throws InterruptedException {
        // 1 启动浏览器
        // WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Firefox46\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        // 2.输入网址
        driver.get("https://www.baidu.com");
        // 3.找到元素，输入搜索内容
        driver.findElement(By.id("kw")).sendKeys("你好");
        // 4.点击搜索按钮
        driver.findElement(By.id("su")).click();
        // 5.等待网络等延时加载
        Thread.sleep(7000);
        // 6.关闭浏览器，关闭驱动进程
        driver.quit();
    }

}
