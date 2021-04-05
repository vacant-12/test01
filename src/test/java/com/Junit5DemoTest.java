package com;

import org.junit.jupiter.api.*;

@DisplayName("junit5演示类")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5DemoTest {
    @BeforeAll
    static void before(){
        System.out.println("before");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }
    @Test
    @DisplayName("fun方法")
    @RepeatedTest(2)
    void fun(){
        System.out.println("fun");
    }

    @Test
    @DisplayName("fun1方法")
    void fun1(){
        System.out.println("fun1");
    }
    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }
    @AfterAll
    static void after(){
        System.out.println("after");
    }
}
