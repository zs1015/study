package com.zs.auto.day07_1029.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebAutoUtils {

    /**
     * 获取WebDriver工具类
     * @param browserName 浏览器名
     * @param seleniumVersion selenium版本号
     * @return
     */
    public static WebDriver getDriver(String browserName, String seleniumVersion) {
        if ("IE".equalsIgnoreCase(browserName)) {
            return getIEDriver();
        } else if ("Chrome".equalsIgnoreCase(browserName)) {
            return getChromeDriver();
        } else if ("FireFox".equalsIgnoreCase(browserName)) {
            return getFireFoxDriver(seleniumVersion);
        } else if ("Edge".equalsIgnoreCase(browserName)) {
            return getEdgeDriver();
        } else if ("Safiri".equalsIgnoreCase(browserName)) {
            // TODO
            return getSafiriDriver();
        } else if ("Opera".equalsIgnoreCase(browserName)) {
            // TODO
            return getOperaDriver();
        } else {
            throw new RuntimeException("不存的在浏览器");
        }
    }

    private static WebDriver getEdgeDriver() {
        System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY,
                "src/main/resources/driver/MicrosoftWebdriver.exe");
        return new EdgeDriver();
    }

    private static WebDriver getFireFoxDriver(String seleniumVersion) {
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Firefox69\\firefox.exe");
        if (!("2.x".equalsIgnoreCase(seleniumVersion))) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,
                    "src/main/resources/driver/geckodriver.exe");
        }
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                "src/main/resources/driver/chromedriver.exe");
        return new ChromeDriver();
    }

    private static WebDriver getIEDriver() {
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,
                "src/main/resources/driver/IEDriverServer.exe");
        // 设置一个期望能力（创建一个期望能力的对象，打开浏览器前设置 ）
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);// 忽略缩放级别
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);// 忽略安全域设置
        capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.baidu.com");// 忽略
        return new InternetExplorerDriver(capabilities);
    }

    private static WebDriver getOperaDriver() {
        // TODO Auto-generated method stub
        return null;
    }

    private static WebDriver getSafiriDriver() {
        // TODO Auto-generated method stub
        return null;
    }

}
