package com.training.tdd.tddinnova.app;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class Order {
    private String orderName;
    private String orderUid;
    private Double price;
    private Long customerId;

}
