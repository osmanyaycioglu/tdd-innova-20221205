package com.training.tdd.tddinnova.strings;

public class TestData {
    private String testStr;
    private int    result;

    public String getTestStr() {
        return testStr;
    }

    public TestData setTestStr(String testStrParam) {
        testStr = testStrParam;
        return this;
    }

    public int getResult() {
        return result;
    }

    public TestData setResult(int resultParam) {
        result = resultParam;
        return this;
    }

    @Override
    public String toString() {
        return "TestData{" +
               "testStr='" + testStr + '\'' +
               ", result=" + result +
               '}';
    }
}
