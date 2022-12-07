package com.training.tdd.tddinnova.app;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class OrderInfo {
    private String orderName;
    private String orderUid;
    private Double calculatedPrice;
    private int orderStatus;
    private Order order;

}
