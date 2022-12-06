package com.training.tdd.tddinnova.strings;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import com.training.tdd.tddinnova.MyGroup;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

// @DisplayNameGeneration(MyDisplaynameGenerator.class)
@DisplayName("StringUtil testleri")
class StringUtil2Test implements ITestGeneralUtils {

    private StringUtil stringUtil;

    @BeforeEach
    public void setUp() {
        stringUtil = new StringUtil();
    }

    @Test
    @Tag("char.count")
    void getCharCount(TestInfo testInfoParam) {
        System.out.println(getTestString(testInfoParam));
        Assertions.assertEquals(0,
                                stringUtil.getCharCount(null));
        Assertions.assertEquals(0,
                                stringUtil.getCharCount("  "));
        Assertions.assertEquals(5,
                                stringUtil.getCharCount(" osman "));
        Assertions.assertEquals(3,
                                stringUtil.getCharCount("abc"));
        Assertions.assertEquals(9,
                                stringUtil.getCharCount("abc_osman"));
        Assertions.assertEquals(7,
                                stringUtil.getCharCount("test123"));
    }

    @Test
    @Tag("char.count")
    void getCharCount_Other(TestInfo testInfoParam,
                            TestReporter reporterParam) {
        System.out.println(getTestString(testInfoParam));
        reporterParam.publishEntry(getTestString(testInfoParam));
        Assertions.assertEquals(0,
                                stringUtil.getCharCount(null));
        Assertions.assertEquals(0,
                                stringUtil.getCharCount("  "));
        Assertions.assertEquals(5,
                                stringUtil.getCharCount(" osman "));
        Assertions.assertEquals(3,
                                stringUtil.getCharCount("abc"));
        Assertions.assertEquals(9,
                                stringUtil.getCharCount("abc_osman"));
        Assertions.assertEquals(7,
                                stringUtil.getCharCount("test123"));
    }

}