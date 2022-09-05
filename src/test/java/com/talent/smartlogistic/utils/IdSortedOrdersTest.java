package com.talent.smartlogistic.utils;

import com.talent.smartlogistic.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdSortedOrdersTest {

    @Test
    public void should_SaveOrders_InCorrectOrder_ById() {
        IdSortedOrders<Order> idSortedOrders = new IdSortedOrders<Order>();

        Order orderA = Order.builder()
                .id(1)
                .build();

        Order orderB = Order.builder()
                .id(7)
                .build();

        Order orderC = Order.builder()
                .id(3)
                .build();

        idSortedOrders.orderedAdd(orderB);
        idSortedOrders.orderedAdd(orderC);
        idSortedOrders.orderedAdd(orderA);

        Assertions.assertEquals(idSortedOrders.getFirst(), orderA);
        Assertions.assertEquals(idSortedOrders.getLast(), orderB);
    }
}
