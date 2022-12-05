package com.training.tdd.tddinnova;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class MyDisplaynameGenerator extends DisplayNameGenerator.ReplaceUnderscores {

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass,
                                               Method testMethod) {
        StringBuilder stringBuilder = new StringBuilder();
        MyGroup annotation = testClass.getAnnotation(MyGroup.class);
        if (annotation != null){
            stringBuilder.append(annotation.value()).append("--->");
        }
        stringBuilder.append(testClass.getSimpleName()).append(" + ");
        MyGroup annotation1 = testMethod.getAnnotation(MyGroup.class);
        if (annotation1 != null){
            stringBuilder.append(annotation1.value()).append("<>");
        }
        stringBuilder.append(testMethod.getName().replace("_", " - "));
        return stringBuilder.toString();
    }
}
