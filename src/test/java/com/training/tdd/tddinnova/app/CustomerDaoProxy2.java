package com.training.tdd.tddinnova.app;

public class CustomerDaoProxy2 extends CustomerDao {

    @Override
    public Customer findCustomer(Long customerId) {
        return super.findCustomer(customerId);
    }
}
