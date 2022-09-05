package com.talent.smartlogistic.repository;

import com.talent.smartlogistic.utils.IdSortedOrders;
import com.talent.smartlogistic.model.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;


@Repository
public class OrderRepository {

    IdSortedOrders<Order> orders = new IdSortedOrders<>();

    @PostConstruct
    private void initData() {
        Order orderA = Order.builder()
                .id(10)
                .customerName("Jhonathan Salazar")
                .volume(10)
                .price(100)
                .build();

        Order orderB = Order.builder()
                .id(20)
                .customerName("Julian Munoz")
                .volume(23)
                .price(321)
                .build();

        Order orderC = Order.builder()
                .id(22)
                .customerName("Andres Penagos")
                .volume(11)
                .price(111)
                .build();

        orders.add(orderA);
        orders.add(orderB);
        orders.add(orderC);
    }

    public IdSortedOrders<Order> list() {
        return orders;
    }

    public boolean add(Order order) {
        orders.stream()
                .map(Order::getId)
                .filter(id -> id.equals(order.getId()))
                .findAny()
                .ifPresent(id -> {
                    throw new RuntimeException("Order with id " + id + " already exist");
                });

        return orders.orderedAdd(order);
    }

    public Order get(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
