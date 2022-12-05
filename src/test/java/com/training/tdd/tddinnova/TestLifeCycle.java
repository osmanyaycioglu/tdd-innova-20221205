package com.training.tdd.tddinnova;

import org.junit.jupiter.api.*;
// Default davranış
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MyOrder.class)
@TestClassOrder(ClassOrderer.DisplayName.class)
@DisplayNameGeneration(MyDisplaynameGenerator.class)
@MyGroup("training.test")
public class TestLifeCycle {

    private Calculator calculator = new Calculator();

    public TestLifeCycle() {
        System.out.println("TestLifeCycle yaratıldı");
    }

    @BeforeAll
    static void setup() {
        System.out.println("Before ALL");
    }

    @AfterAll
    static void destroy() {
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
    @Order(3)
    @MyGroup("group2")
    void test2() {
        System.out.println("Test2");
    }

    @Test
    @Order(1)
    @DisplayName("Testing all other options")
    @MyGroup("group1")
    void test1() {
        System.out.println("Test1");
    }

    @Test
    @Order(4)
    @MyGroup("group1")
    void test3() {
        System.out.println("Test3");
    }

    @Test
    @Order(2)
    @MyGroup("group2")
    void test4() {
        System.out.println("Test4");
    }

    @Test
    @MyGroup("group3")
    void I_am_testing_another_method_should_return_my_value(){
        System.out.println("Test5");
    }

}
