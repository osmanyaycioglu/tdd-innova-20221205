package com.training.tdd.tddinnova;

import com.training.tdd.tddinnova.strings.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TddInnovaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddInnovaApplication.class,
                              args);
        StringUtil stringUtil = new StringUtil();
        stringUtil.getNameRuleIndex("deneme mehmet");
    }

}
