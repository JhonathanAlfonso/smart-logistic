package com.talent.smartlogistic.controller;

import com.talent.smartlogistic.model.Order;
import com.talent.smartlogistic.repository.OrderRepository;
import com.talent.smartlogistic.utils.IdSortedOrders;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public IdSortedOrders<Order> list() {
        return orderRepository.list();
    }

    @PostMapping
    public Order save(@Valid @RequestBody Order order) {
        orderRepository.add(order);
        return order;
    }
}
