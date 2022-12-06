package com.training.tdd.tddinnova.strings;

import org.junit.jupiter.api.TestInfo;

public interface ITestGeneralUtils {

    default String getTestString(TestInfo testInfoParam) {
        return testInfoParam.getDisplayName()
               + " -> "
               + testInfoParam.getTestClass()
               + " : "
               + testInfoParam.getTestMethod()
               + " / "
               + testInfoParam.getTags();
    }


}
