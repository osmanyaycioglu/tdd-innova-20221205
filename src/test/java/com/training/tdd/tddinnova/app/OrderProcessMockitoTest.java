package com.training.tdd.tddinnova.app;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Equals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(MyDisplaynameGenerator.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderProcessMockitoTest {

    private OrderProcess orderProcess;

    @Mock
    private CustomerDao customerDao2;

    @BeforeEach
    public void setup() {
        CustomerDao customerDao = Mockito.mock(CustomerDao.class);
        Mockito.when(customerDao.findCustomer(1L))
               .thenReturn(Customer.builder()
                                   .withCustomerId(1L)
                                   .withName("osman")
                                   .withSurname("yayci")
                                   .withDiscount(0.2D)
                                   .build())
               .thenReturn(Customer.builder()
                                   .withCustomerId(1L)
                                   .withName("osman")
                                   .withSurname("yayci")
                                   .withDiscount(0.8D)
                                   .build());
        ;
        Mockito.when(customerDao.findCustomer(2L))
               .thenReturn(Customer.builder()
                                   .withCustomerId(2L)
                                   .withName("ali")
                                   .withSurname("veli")
                                   .withDiscount(0.5D)
                                   .build());
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
        orderInfo = orderProcess.placeOrder(order);
        Assertions.assertThat(orderInfo)
                  .isNotNull()
                  .isExactlyInstanceOf(OrderInfo.class);
        Assertions.assertThat(orderInfo.getOrderStatus())
                  .isEqualTo(1);
        Assertions.assertThat(orderInfo.getCalculatedPrice())
                  .isCloseTo(20D, Percentage.withPercentage(0.1D));
        Assertions.assertThat(orderInfo.getOrderName())
                  .isEqualTo(orderName);
        Assertions.assertThat(orderInfo.getOrderUid())
                  .isEqualTo(orderUid);

    }

    @Test
    void given_second_customer_order_test() {
        String orderName = "order2";
        String orderUid = "237fnfdh";
        Order order = Order.builder()
                           .withOrderName(orderName)
                           .withOrderUid(orderUid)
                           .withCustomerId(2L)
                           .withPrice(100D)
                           .build();
        OrderInfo orderInfo = orderProcess.placeOrder(order);
        Assertions.assertThat(orderInfo)
                  .isNotNull()
                  .isExactlyInstanceOf(OrderInfo.class);
        Assertions.assertThat(orderInfo.getOrderStatus())
                  .isEqualTo(1);
        Assertions.assertThat(orderInfo.getCalculatedPrice())
                  .isEqualTo(90D);
        Assertions.assertThat(orderInfo.getOrderName())
                  .isEqualTo(orderName);
        Assertions.assertThat(orderInfo.getOrderUid())
                  .isEqualTo(orderUid);
    }

    @Test
    void given_first_customer_order_test_2() {
        orderProcess = new OrderProcess(customerDao2);
        Mockito.when(customerDao2.findCustomer(ArgumentMatchers.eq(1L)))
               .thenReturn(Customer.builder()
                                   .withCustomerId(1L)
                                   .withName("osman")
                                   .withSurname("yayci")
                                   .withDiscount(0.2D)
                                   .build());

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