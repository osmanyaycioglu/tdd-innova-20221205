package com.training.tdd.tddinnova.strings;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import com.training.tdd.tddinnova.MyGroup;
import org.junit.jupiter.api.*;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(MyDisplaynameGenerator.class)
@DisplayName("StringUtil testleri")
class StringUtilTest {

    private StringUtil stringUtil;

    @BeforeEach
    public void setUp() {
        stringUtil = new StringUtil();
    }

    @Nested
    @DisplayNameGeneration(MyDisplaynameGenerator.class)
    @MyGroup("training.test")
    class NullChecks {
        private static final int MAX_COUNT_FOR_XYZ = 1000;

        @BeforeEach
        public void setUp() {
            stringUtil.setCount(10);
        }

        @Test
        @MyGroup("getCharCount.null")
        void getCharCount_Null_Check_With_Max_Count() {
            // Don't delete
            stringUtil.setCount(MAX_COUNT_FOR_XYZ);
            Assertions.assertEquals(0,
                                    stringUtil.getCharCount(null));

        }

        @Test
        @MyGroup("getCharCount.null")
        void getNameRuleIndex_Null_Check() {
            Assertions.assertEquals(0,
                                    stringUtil.getNameRuleIndex(null));
        }

        @Nested
        class NestedNull {

            @Test
            @MyGroup("getCharCount.null")
            void getNameRuleIndex_Nested_Null_Check() {
                Assertions.assertEquals(0,
                                        stringUtil.getNameRuleIndex(null));
            }

        }
    }

    @Test
    void getCharCount() {
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
    void getCharCount_With_All() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(0,
                                              stringUtil.getCharCount(null)),
                () -> Assertions.assertEquals(0,
                                              stringUtil.getCharCount("  ")),
                () -> Assertions.assertEquals(5,
                                              stringUtil.getCharCount(" osman ")),
                () -> Assertions.assertEquals(3,
                                              stringUtil.getCharCount("abc")),
                () -> Assertions.assertEquals(9,
                                              stringUtil.getCharCount("abc_osman")),
                () -> Assertions.assertEquals(7,
                                              stringUtil.getCharCount("test123")));
    }

    @Test
    void getCharCount_Null_Checks() {
        Assertions.assertEquals(0,
                                stringUtil.getCharCount(null));
        Assertions.assertEquals(0,
                                stringUtil.getCharCount("null"));
        Assertions.assertEquals(0,
                                stringUtil.getCharCount("  null"));
    }

    @Test
    void divideChar() {
        Assertions.assertEquals(0,
                                stringUtil.divideString(null,
                                                        "a"));
        Assertions.assertEquals(5,
                                stringUtil.divideString("osman",
                                                        null));
        Assertions.assertEquals(5,
                                stringUtil.divideString("osman",
                                                        "a"));
    }


    @Test
    void getCharCountStr() {
    }

    @Test
    void getNameRuleIndex() {
        Assertions.assertEquals(0,
                                stringUtil.getNameRuleIndex(null));
        Assertions.assertEquals(1,
                                stringUtil.getNameRuleIndex("ali"));
        Assertions.assertEquals(1,
                                stringUtil.getNameRuleIndex("osman ali"));
        Assertions.assertEquals(2,
                                stringUtil.getNameRuleIndex("osman alaz"));
        Assertions.assertEquals(3,
                                stringUtil.getNameRuleIndex("osman elez"));
        Assertions.assertEquals(3,
                                stringUtil.getNameRuleIndex("osman    "));
        Assertions.assertEquals(4,
                                stringUtil.getNameRuleIndex("deneme123"));
        Assertions.assertEquals(4,
                                stringUtil.getNameRuleIndex("   1 2 3 "));
        try {
            stringUtil.getNameRuleIndex("mehmet elti");
        } catch (Exception eParam) {
            if (!(eParam instanceof IllegalArgumentException)) {
                throw new AssertionFailedError("IllegalArgumentException gelmeliydi : " + eParam.getClass());
            }
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> stringUtil.getNameRuleIndex("   mehmet "));
    }
}