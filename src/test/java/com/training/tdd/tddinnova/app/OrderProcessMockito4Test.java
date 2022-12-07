package com.training.tdd.tddinnova.app;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(MyDisplaynameGenerator.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderProcessMockito4Test {
    @Spy
    private CustomerDao customerDao;

    @InjectMocks
    private OrderProcess2 orderProcess;

    @Captor
    private ArgumentCaptor<Long> longArgumentCaptor;

    @BeforeEach
    public void setup() {
    }

    @Test
    void given_first_customer_order_test() {
        Mockito.doReturn(Customer.builder()
                                 .withCustomerId(1L)
                                 .withName("osman")
                                 .withSurname("yayci")
                                 .withDiscount(0.2D)
                                 .build())
               .when(customerDao)
               .findCustomer(ArgumentMatchers.eq(1L));
//        Mockito.when(customerDao.findCustomer(ArgumentMatchers.eq(1L)))
//               .thenReturn(Customer.builder()
//                                   .withCustomerId(1L)
//                                   .withName("osman")
//                                   .withSurname("yayci")
//                                   .withDiscount(0.2D)
//                                   .build())
//               .thenCallRealMethod();

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
        Mockito.verify(customerDao,
                       Mockito.atLeast(2))
               .findCustomer(longArgumentCaptor.capture());
        List<Long> allValues = longArgumentCaptor.getAllValues();
        System.out.println("Called args : " + allValues);
        Mockito.verify(customerDao,
                       Mockito.atLeast(1))
               .findCustomerByName(ArgumentMatchers.anyString());
        // OrderInfo orderInfo2 = orderProcess.placeOrder2(order);

    }
}