package com.training.tdd.tddinnova.app;


public class OrderProcess {

    private CustomerDao customerDao;

    public OrderProcess(CustomerDao customerDaoParam) {
        customerDao = customerDaoParam;
    }

    public OrderInfo placeOrder(Order orderParam) {
        Customer customer = customerDao.findCustomer(orderParam.getCustomerId());
        if (customer != null) {
            // Calculate
            return OrderInfo.builder()
                            .withOrderStatus(1)
                            .withCalculatedPrice(100D * (1D - customer.getDiscount()))
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
