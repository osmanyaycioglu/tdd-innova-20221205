package com.training.tdd.tddinnova.app;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(MyDisplaynameGenerator.class)
class OrderProcessTest {

    private OrderProcess orderProcess;

    @BeforeEach
    public void setup() {
        CustomerDao customerDao = new CustomerDaoProxy();
        orderProcess = new OrderProcess(customerDao);
    }

    @Test
    void given_first_customer_order_test() {
        String orderName = "order1";
        String orderUid = "238923f";
        Order order = Order.builder()
                           .withOrderName(orderName)
                           .withOrderUid(orderUid)
                           .withCustomerId(1L)
                           .withPrice(100D)
                           .build();
        OrderInfo orderInfo = orderProcess.placeOrder(order);
        Assertions.assertThat(orderInfo)
                  .isNotNull()
                  .isExactlyInstanceOf(OrderInfo.class);
        Assertions.assertThat(orderInfo.getOrderStatus())
                  .isEqualTo(1);
        Assertions.assertThat(orderInfo.getCalculatedPrice())
                  .isEqualTo(80D);
        Assertions.assertThat(orderInfo.getOrderName())
                  .isEqualTo(orderName);
        Assertions.assertThat(orderInfo.getOrderUid())
                  .isEqualTo(orderUid);
    }
}