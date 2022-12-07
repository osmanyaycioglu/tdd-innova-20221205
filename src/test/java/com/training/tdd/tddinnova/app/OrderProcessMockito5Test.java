package com.training.tdd.tddinnova.app;

import com.training.tdd.tddinnova.MyDisplaynameGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(MyDisplaynameGenerator.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderProcessMockito5Test {
    @Mock
    private CustomerDao customerDao2;

    @InjectMocks
    private OrderProcess2 orderProcess;


    @BeforeEach
    public void setup() {
    }

    static Customer findCustomerAnswer(InvocationOnMock i) {
        Long input = i.getArgument(0);
        switch (input.intValue()) {
            case 1:
                return Customer.builder()
                               .withCustomerId(1L)
                               .withName("osman")
                               .withSurname("yayci")
                               .withDiscount(0.2D)
                               .build();
            case 2:
            default:
                return Customer.builder()
                               .withCustomerId(input)
                               .withName("mehmet")
                               .withSurname("yayci")
                               .withDiscount(0.2D)
                               .build();

        }
    }

    @Test
    void given_first_customer_order_test() {
        Mockito.when(customerDao2.findCustomer(ArgumentMatchers.anyLong()))
               .thenAnswer(OrderProcessMockito5Test::findCustomerAnswer);
//        Mockito.when(customerDao2.findCustomer(ArgumentMatchers.eq(3L)))
//               .thenThrow(new IllegalArgumentException("3 olamaz"));

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