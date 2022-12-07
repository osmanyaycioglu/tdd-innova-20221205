package com.training.tdd.tddinnova.strings;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;

@DisplayName("StringUtil testleri")
class StringUtil5Test implements ITestGeneralUtils {

    private StringUtil stringUtil;

    @BeforeEach
    public void setUp() {
        stringUtil = new StringUtil();
    }

    @Test
    void getCharCount(TestInfo testInfoParam) {
        System.out.println(getTestString(testInfoParam));
        Assertions.assertThat(stringUtil.getCharCount("osman"))
                  .isPositive()
                  .isEqualTo(5)
                  .isCloseTo(6,
                             Percentage.withPercentage(30D));
    }

    @Test
    void concat_test(TestInfo testInfoParam) {
        Assertions.assertThat(stringUtil.concat(EConcatType.SNAKE,
                                                "osman",
                                                "yayci",
                                                "52",
                                                "trainer"))
                  .as("osman string toplama testi")
                  .containsIgnoringCase("osman")
                  .contains("yayci")
                  .startsWith("osman")
                  .containsOnlyOnce("53")
                  .doesNotEndWith("_")
                  .hasSizeBetween(10,
                                  20)
        ;
    }

}