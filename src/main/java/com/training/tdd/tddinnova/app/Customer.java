package com.training.tdd.tddinnova.app;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class Customer {
    private Long customerId;
    private String name;
    private String surname;
    private Double discount;

}
