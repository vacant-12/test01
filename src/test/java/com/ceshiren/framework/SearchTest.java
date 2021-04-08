package com.ceshiren.framework;

import org.junit.jupiter.api.Test;

public class SearchTest {
    @Test
    void search(){
        MainPage main = new MainPage();
        SearchPage searchPage = main.search();
        searchPage.search("selenium");
    }
}
