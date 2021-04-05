package com.ceshiren.app;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ThePagePoTest {

    private static NewMainPage mainPage;

    @BeforeEach
    void beforeEach() throws IOException{
        mainPage = new NewMainPage();
    }

/*
    @AfterEach
    void afterEach(){
        mainPage.driver.quit();
    }
*/

    @Test
    //@ValueSource(strings = {"kaka","123"})
    void addMember() throws InterruptedException {
        String name = "test003";
        String number = "15012340003";
        //assertTrue(mainPage.nextPage().addMember(name,number).search(name).getPartyInfo().contains(name));
        assertEquals(name,mainPage.nextPage().addMember(name,number).search(name).getPartyInfo());
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    void search(String aName, String aNumber) throws InterruptedException {
        String name = aName;
        String number = aNumber;
        //assertTrue(mainPage.nextPage().addMember(name,number).search(name).getPartyInfo().contains(name));
        assertEquals(name,mainPage.nextPage().addMember(name,number).search(name).getPartyInfo());
    }

    //引入参数化输入添加成员数据
    public Stream<Arguments> getMemberInfo(){
        return Stream.of(Arguments.of("test004","15012340003"),
                Arguments.arguments("test005","15012340004"));
    }

}
