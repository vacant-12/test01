package com.ceshiren.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPage extends BasePage{


    private By parterInfo = By.cssSelector(".js_party_info");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile){
        return this;
    }

    public ContactPage searchDepart(String departName){

        sendKeys(By.id("memberSearchInput"),departName);
        //搜索太快，这里的点击借住隐式等待元素出现
        click(By.cssSelector(".ww_icon_AddMember"));
/*        String content = driver.findElement(By.cssSelector(".js_party_info")).getText();
        System.out.println(content);*/


        return this;
    }

    public String getPartyInfo(){

        String content = driver.findElement(parterInfo).getText();
        System.out.println(content);
        return content;
    }

    public  ContactPage addDepart(String departName) {
        //click(By.cssSelector(".member_colLeft_top_addBtn"));
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"),departName);
        click(By.linkText("选择所属部门"));
        driver.findElements(By.linkText("字节跳动")).get(1).click();
        click(By.linkText("确定"));
        return this;
    }
}
