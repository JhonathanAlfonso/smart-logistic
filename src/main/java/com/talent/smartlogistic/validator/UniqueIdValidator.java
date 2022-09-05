package com.talent.smartlogistic.validator;

import com.talent.smartlogistic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueIdValidator implements ConstraintValidator<UniqueId, Integer> {

    @Autowired
    private final OrderRepository orderRepository;

    public UniqueIdValidator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean isValid(Integer orderId, ConstraintValidatorContext context) {
        return orderRepository.get(orderId) == null;
    }
}
