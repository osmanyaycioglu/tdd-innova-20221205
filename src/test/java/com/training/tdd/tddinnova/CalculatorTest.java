package com.training.tdd.tddinnova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        int add = calculator.add(10,
                                 20);
        if (add != 30) {
            throw new AssertionFailedError("Toplama problemi",
                                           30,
                                           add);
        }
    }

    @Test
    void subs() {
        Calculator calculator = new Calculator();
        int subsResult = calculator.subs(20,
                                         10);
        if (subsResult != 10) {
            throw new AssertionFailedError("Çıkarma problemi",
                                           10,
                                           subsResult);
        }
    }

    @Test
    void subs2() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(10,
                                calculator.subs(20,
                                                10));
    }

}