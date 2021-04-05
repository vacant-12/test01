package com.ceshiren.web;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DriverCommand;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPOTest {

    private static MainPage main;

    @BeforeEach
    void beforeEach() throws IOException, InterruptedException {
        main = new MainPage();
    }

    @AfterEach
     void afterEach(){
        main.driver.quit();
    }


/*    @Test
    void testAddMember() throws IOException, InterruptedException {


        MainPage mainPage = new MainPage();
        ContactPage contactPage  = mainPage.contact();
        //contactPage.addMember("test003","test003","15012340002");
        contactPage.searchDepart("测试开发部");
        String content = contactPage.getPartyInfo();
        assertTrue(content.contains("无任何成员"));
        //assert contactPage.search("test003").getInfo();

        assertTrue(new MainPage().contact().searchDepart("测试开发部").getPartyInfo().contains("无任何成员"));
    }*/

    @Test
    void testSearchMember() throws IOException, InterruptedException {
        assertTrue(main.contact().searchDepart("测试开发部").getPartyInfo().contains("无任何成员"));
    }

    @Test
    void testDepartAdd(){
        String departName = "测试部门";
        assertTrue(main.contact().addDepart(departName).searchDepart(departName).getPartyInfo().contains(departName));
    }
}
