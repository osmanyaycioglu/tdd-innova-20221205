package com.training.tdd.tddinnova.app;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(MyDisplaynameGenerator.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderProcessMockito3Test {
    @Mock
    private CustomerDao customerDao2;

    @InjectMocks
    private OrderProcess2 orderProcess;


    @BeforeEach
    public void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = Files.readString(Paths.get("customers.json"));
        List<Customer> list = objectMapper.readValue(s,
                                           List.class);
        System.out.println(list);
    }


    void write_customer_to_file() throws IOException {
        Customer customer = Customer.builder()
                                 .withCustomerId(1L)
                                 .withName("osman")
                                 .withSurname("yayci")
                                 .withDiscount(0.2D)
                                 .withCustomerDetails(CustomerDetails.builder()
                                                                     .gender("ERKEK")
                                                                     .status("ACTIVE")
                                                                     .group("GROUP1")
                                                                     .build())
                                 .build();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("customers.json");
        objectMapper.writeValue(file,customer);
    }

    @Test
    void given_first_customer_order_test() {
        Mockito.when(customerDao2.findCustomer(ArgumentMatchers.eq(1L)))
               .thenReturn(Customer.builder()
                                   .withCustomerId(1L)
                                   .withName("osman")
                                   .withSurname("yayci")
                                   .withDiscount(0.2D)
                                   .build());
        Mockito.when(customerDao2.findCustomer(ArgumentMatchers.eq(3L)))
               .thenThrow(new IllegalArgumentException("3 olamaz"));

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

        order.setCustomerId(3L);
        Assertions.assertThatThrownBy(() -> orderProcess.placeOrder(order))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining("olamaz")
                  .hasMessageContaining("3")
                  .hasMessage("3 olamaz");

    }
}