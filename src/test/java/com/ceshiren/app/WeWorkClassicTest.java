package com.ceshiren.app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WeWorkClassicTest {

    //public static AppiumDriver driver;
    //@Test
    void search() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","ceshiren.com");
        capabilities.setCapability("appPackage","com.tencent.wework");
        capabilities.setCapability("appActivity",".launch.LaunchSplashActivity");
        capabilities.setCapability("noReset","true");
        AppiumDriver<MobileElement> driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(MobileBy.id("h8q")).click();
        driver.findElement(MobileBy.id("g1n")).sendKeys("test");
    }

    //@BeforeEach
    void beforeEach() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "ceshiren.com");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        capabilities.setCapability("noReset", "true");
        AppiumDriver<MobileElement> driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @Test
    void addMember() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "ceshiren.com");
        capabilities.setCapability("appPackage", "com.tencent.wework");
        capabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        capabilities.setCapability("noReset", "true");
        AppiumDriver<MobileElement> driver = new AppiumDriver<>(
                new URL("http://0.0.0.0:4723/wd/hub"),
                capabilities);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.findElement(MobileBy.xpath("//*[@text='通讯录']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='添加成员']")).click();
        driver.findElement(MobileBy.xpath("//*[@text='手动输入添加']")).click();
        driver.findElement(MobileBy.id("ays")).sendKeys("test003");
        driver.findElement(MobileBy.id("f4m")).sendKeys("15012340003");
        driver.findElement(MobileBy.id("ac9")).click();

    }
}
