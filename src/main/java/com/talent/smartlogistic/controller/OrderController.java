package com.talent.smartlogistic.controller;

import com.talent.smartlogistic.model.Order;
import com.talent.smartlogistic.repository.OrderRepository;
import com.talent.smartlogistic.utils.IdSortedOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public IdSortedOrders<Order> list() {
        return orderRepository.list();
    }

    @PostMapping
    public boolean save(@Valid @RequestBody Order order) {
        return orderRepository.add(order);
    }
}
