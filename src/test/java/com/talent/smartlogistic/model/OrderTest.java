package com.talent.smartlogistic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    public void should_Create_OrderModel_Correctly() {
        Order order = Order.builder()
                .id(1)
                .customerName("John")
                .volume(10)
                .price(1000)
                .build();

        Assertions.assertAll(
                () -> Assertions.assertEquals(order.getId(), 1),
                () -> Assertions.assertEquals(order.getCustomerName(), "John"),
                () -> Assertions.assertEquals(order.getVolume(), 10),
                () -> Assertions.assertEquals(order.getPrice(), 1000)
        );
    }
}
