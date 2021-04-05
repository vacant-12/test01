package com.ceshiren.app;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class NextPage extends AppBasePage{

    public NextPage(AppiumDriver driver) {
        super(driver);
    }
    private By partInfo = By.xpath("//android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView");


    public NextPage search(String name){
        click(By.id("h8q"));
        sendKeys(By.xpath("//*[@text='搜索']"),name);
        return this;
    }

    public NextPage addMember(String name,String number) throws InterruptedException {
        //driver.findElement(MobileBy.xpath("//*[@text='通讯录']")).click();
        click(By.xpath("//*[@text='添加成员']"));
        click(By.xpath("//*[@text='手动输入添加']"));
        sendKeys(By.id("ays"),name);
        sendKeys(By.id("f4m"),number);
        click(By.id("ac9"));
        Thread.sleep(3000);
        click(By.id("h86"));

        return this;
    }

    public String getPartyInfo(){
        String content = driver.findElement(partInfo).getText();
        System.out.println(content);
        return content;
    }
}
