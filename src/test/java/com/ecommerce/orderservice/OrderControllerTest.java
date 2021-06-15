package com.ecommerce.orderservice;
import static org.assertj.core.api.Assertions.assertThat;

import com.ecommerce.orderservice.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//Verifies if the context is creating the Controller
@SpringBootTest
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;
    @Test
    public void contextLoads() throws Exception {
        assertThat(orderController).isNotNull();
    }
}
