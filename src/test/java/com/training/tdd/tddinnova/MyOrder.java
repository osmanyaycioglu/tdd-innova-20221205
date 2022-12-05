package com.training.tdd.tddinnova;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

public class MyOrder implements MethodOrderer {

    @Override
    public void orderMethods(MethodOrdererContext context) {
        List<? extends MethodDescriptor> methodDescriptors = context.getMethodDescriptors();
        for (MethodDescriptor methodDescriptor : methodDescriptors) {
            Method method = methodDescriptor.getMethod();
            Order annotation = method.getAnnotation(Order.class);
            if (annotation != null){
                int value = annotation.value();
            }
        }
    }

}
