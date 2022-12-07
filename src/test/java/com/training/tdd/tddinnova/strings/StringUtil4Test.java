package com.training.tdd.tddinnova.strings;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

@DisplayNameGeneration(MyDisplaynameGenerator.class)
public class StringUtil4Test {
    private StringUtil stringUtil;

    @BeforeEach
    public void setup() {
        stringUtil = new StringUtil();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,
                         2,
                         5,
                         6,
                         7
    })
    void test1(int intVal) {
        System.out.println(intVal);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @NullAndEmptySource
    @ValueSource(strings = {"osman,5",
                            "osman1,6",
                            "os man,6"
    })
    void test2(String str) {
        System.out.println(str);
    }

    @ParamTest
    @ValueSource(strings = {"osman,5",
                            "osman1,6",
                            "os man,6"
    })
    void test3(String str) {
        System.out.println(str);
    }

    @ParameterizedTest
    @MethodSource("strMethodSource")
    void test4(String str) {
        System.out.println(str);
    }

    @ParameterizedTest
    @MethodSource("testDataSource")
    void test5(TestData currentTestData) {
        Assertions.assertEquals(currentTestData.getResult(),
                                stringUtil.getCharCount(currentTestData.getTestStr()),
                                currentTestData.getTestStr()
                                + " : "
                                + currentTestData.getResult()
                                + " olmalıydı.");

    }

    @ParameterizedTest
    @CsvSource({"osman,5",
                "osman12,7",
                "osman 13,8",
                "deneme,6",
                " deneme,6"
    })
    void test5(String testStr,
               int result) {
        Assertions.assertEquals(result,
                                stringUtil.getCharCount(testStr),
                                testStr
                                + " : "
                                + result
                                + " olmalıydı.");

    }

    @ParameterizedTest
    @CsvFileSource(files = "./src/test/resources/str.txt")
    void test6(String testStr,
               int result) {
        Assertions.assertEquals(result,
                                stringUtil.getCharCount(testStr),
                                testStr
                                + " : "
                                + result
                                + " olmalıydı.");
    }

    static Stream<String> strMethodSource() {
        return Stream.of("osman",
                         "osman2",
                         "osman3");
    }

    static Stream<TestData> testDataSource() throws IOException {
        // System.out.println(Paths.get("./test/resources/").toAbsolutePath());
        return Files.readAllLines(Paths.get("./src/test/resources/str.txt"))
                    .stream()
                    .map(s -> s.split(","))
                    .filter(sa -> sa.length == 2)
                    .map(sa -> new TestData().setTestStr(sa[0])
                                             .setResult(Integer.parseInt(sa[1])));
    }

    @ParameterizedTest(name = "{index} -- {displayName} --= {arguments} ")
    @ArgumentsSource(Test6ArgumentSource.class)
    void test6(TestData currentTestData,
               String testName) {
        Assertions.assertEquals(currentTestData.getResult(),
                                stringUtil.getCharCount(currentTestData.getTestStr()),
                                testName
                                + " --> "
                                + currentTestData.getTestStr()
                                + " : "
                                + currentTestData.getResult()
                                + " olmalıydı.");

    }

    static class Test6ArgumentSource implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(Arguments.arguments(new TestData().setTestStr("osman")
                                                               .setResult(5),
                                                 "Normal osman testi"),
                             Arguments.arguments(new TestData().setTestStr("o s m a n")
                                                               .setResult(9),
                                                 "Boşluklu osman testi"),
                             Arguments.arguments(new TestData().setTestStr("12 osman")
                                                               .setResult(8),
                                                 "Rakam boşluk osman testi"));
        }
    }
}
