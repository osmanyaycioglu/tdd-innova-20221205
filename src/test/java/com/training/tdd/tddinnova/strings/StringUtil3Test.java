package com.training.tdd.tddinnova.strings;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import org.junit.jupiter.api.*;

import java.util.*;

@DisplayNameGeneration(MyDisplaynameGenerator.class)
public class StringUtil3Test {

    private StringUtil stringUtil;

    private static class TestData {
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
    }

    private static List<TestData> testDataList = Arrays.asList(new TestData().setTestStr("osman")
                                                                             .setResult(5),
                                                               new TestData().setTestStr("123")
                                                                             .setResult(3),
                                                               new TestData().setTestStr("osman123")
                                                                             .setResult(8),
                                                               new TestData().setTestStr("o s m a n")
                                                                             .setResult(9),
                                                               new TestData().setTestStr("o_s_m_a_n")
                                                                             .setResult(9),
                                                               new TestData().setTestStr("o-s-m-a-n")
                                                                             .setResult(9),
                                                               new TestData().setTestStr("osMa,n")
                                                                             .setResult(6),
                                                               new TestData().setTestStr(" osm an ")
                                                                             .setResult(6)
    );

    private static TestData[] testData = new TestData[]{
            new TestData().setTestStr("osman").setResult(5),
            new TestData().setTestStr("123").setResult(3),
            new TestData().setTestStr("osman123").setResult(8),
            new TestData().setTestStr("o s m a n").setResult(9),
            new TestData().setTestStr("o_s_m_a_n").setResult(9),
            new TestData().setTestStr("o-s-m-a-n").setResult(9),
            new TestData().setTestStr("osMa,n").setResult(6),
            new TestData().setTestStr(" osm an ").setResult(6)
    };

    private static Map<String, Integer> testMap = new TreeMap<>();

    @BeforeAll
    public static void beforeAll() {
        testMap.put("osman",
                    5);
        testMap.put("osman1",
                    6);
        testMap.put("osman ",
                    5);
    }

    @BeforeEach
    public void setup() {
        stringUtil = new StringUtil();
    }

    @RepeatedTest(value = 8, name = "Test string count {displayName} - {currentRepetition}/{totalRepetitions}")
    void test_string_char_count(RepetitionInfo repetitionInfoParam) {
        int currentRepetition = repetitionInfoParam.getCurrentRepetition() - 1;
        Assertions.assertEquals(testData[currentRepetition].result,
                                stringUtil.getCharCount(testData[currentRepetition].testStr),
                                testData[currentRepetition].testStr
                                + " : "
                                + testData[currentRepetition].result
                                + " olmalıydı.");

    }

    @RepeatedTest(value = 8, name = "Test string count {displayName} - {currentRepetition}/{totalRepetitions}")
    void test_string_char_count_with_list(RepetitionInfo repetitionInfoParam) {
        int currentRepetition = repetitionInfoParam.getCurrentRepetition() - 1;
        TestData currentTestData = testDataList.get(currentRepetition);
        Assertions.assertEquals(currentTestData.result,
                                stringUtil.getCharCount(currentTestData.testStr),
                                currentTestData.testStr
                                + " : "
                                + currentTestData.result
                                + " olmalıydı.");

    }

    @RepeatedTest(value = 3, name = "Test string count {displayName} - {currentRepetition}/{totalRepetitions}")
    void test_string_char_count_with_map(RepetitionInfo repetitionInfoParam) {
        int currentRepetition = repetitionInfoParam.getCurrentRepetition() - 1;
        Set<Map.Entry<String, Integer>> entries = testMap.entrySet();
        int count = 0;
        Map.Entry<String, Integer> testData = null;
        for (Map.Entry<String, Integer> entry : entries) {
            if (count == currentRepetition ) {
                testData = entry;
                break;
            }
            count++;
        }
        if (testData != null) {
            System.out.println("Testing : " + currentRepetition + " Data : " + testData.getKey());
            Assertions.assertEquals(testData.getValue(),
                                    stringUtil.getCharCount(testData.getKey()),
                                    testData.getKey()
                                    + " : "
                                    + testData.getValue()
                                    + " olmalıydı.");
        }

    }

}
