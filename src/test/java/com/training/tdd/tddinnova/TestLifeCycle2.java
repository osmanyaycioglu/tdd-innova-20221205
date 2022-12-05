package com.training.tdd.tddinnova;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("MyFirstTests bütün testler")
public class TestLifeCycle2 {

    private Calculator calculator = null;

    public TestLifeCycle2() {
        System.out.println("TestLifeCycle yaratıldı");
    }

    @BeforeAll
    void setup() {
        System.out.println("Before ALL");
    }

    @AfterAll
    void destroy() {
        System.out.println("Before ALL");
    }

    @BeforeEach
    void setupEach() {
        calculator = new Calculator();
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("After Each");
    }

    @Test
    @DisplayName("MyFirstTests --> null testleri")
    void test1() {
        System.out.println("Test1");
    }

    @Test
    void MyFirstTests_null_testleri() {
        System.out.println("Test1");
    }


    @Test
    void test2() {
        System.out.println("Test2");
    }

}
