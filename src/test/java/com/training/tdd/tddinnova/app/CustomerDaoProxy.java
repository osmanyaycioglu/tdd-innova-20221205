package com.training.tdd.tddinnova.app;

public class CustomerDaoProxy extends CustomerDao {

    @Override
    public Customer findCustomer(Long customerId) {
        if (customerId == 1) {

            return Customer.builder()
                           .withCustomerId(customerId)
                           .withName("osman")
                           .withSurname("yayci")
                           .withDiscount(0.2D)
                           .build();
        } else if (customerId == 2) {
            return Customer.builder()
                           .withCustomerId(customerId)
                           .withName("ali")
                           .withSurname("veli")
                           .withDiscount(0.1D)
                           .build();

        }
        return Customer.builder()
                       .withCustomerId(customerId)
                       .withName("mehmet")
                       .withSurname("yayci")
                       .withDiscount(0D)
                       .build();
    }
}
