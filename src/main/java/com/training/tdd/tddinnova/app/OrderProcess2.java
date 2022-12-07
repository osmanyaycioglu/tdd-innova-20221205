package com.training.tdd.tddinnova.app;


public class OrderProcess2 {

    private CustomerDao customerDao;

    public OrderProcess2() {
        customerDao = new CustomerDao();
    }

    public OrderInfo placeOrder(Order orderParam) {
        Customer customer = customerDao.findCustomer(orderParam.getCustomerId());
        if (customer != null) {
            // Calculate
            return OrderInfo.builder()
                            .withOrderStatus(1)
                            .withCalculatedPrice(100D * (1 - customer.getDiscount()))
                            .withOrderName(orderParam.getOrderName())
                            .withOrderUid(orderParam.getOrderUid())
                            .build();
        }
        return OrderInfo.builder()
                        .withOrderStatus(9)
                        .withCalculatedPrice(0D)
                        .withOrderName(orderParam.getOrderName())
                        .withOrderUid(orderParam.getOrderUid())
                        .build();

    }

}
