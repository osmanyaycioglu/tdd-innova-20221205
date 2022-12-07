package com.training.tdd.tddinnova.strings;

import org.springframework.util.StringUtils;

public class StringUtil {

    private int count;

    int getCharCount(String str) {
        if (str == null) {
            return 0;
        }
        if ("null".equalsIgnoreCase(str.trim())) {
            return 0;
        }
        return str.trim()
                  .length();
    }

    public String concat(EConcatType concatTypeParam,
                         String... stringsParam) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringsParam.length; i++) {
            stringBuilder.append(stringsParam[i]);
            if (i < stringsParam.length - 1) {
                stringBuilder.append(concatTypeParam.getDivider());
            }
        }
        return stringBuilder.toString();
    }

    public int getNameRuleIndex(String str) {
        if (str == null) {
            return 0;
        } else if (str.contains("ali")) {
            return 1;
        } else if (str.contains("osman")) {
            if (str.substring(6)
                   .contains("a")) {
                return 2;
            } else {
                return 3;
            }
        } else if (str.contains("mehmet")) {
            throw new IllegalArgumentException("mehmet olmaz");
        } else {
            return 4;
        }
    }


    public int divideString(String str1,
                            String str2) {
        if (str2 == null) {
            return getCharCount(str1);
        }
        return getCharCount(str1) / getCharCount(str2);
    }

    public String getCharCountStr(String str) {
        return "String : " + getCharCount(str);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int countParam) {
        count = countParam;
    }
}
