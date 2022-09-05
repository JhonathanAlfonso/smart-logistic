package com.talent.smartlogistic.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
public class Order implements Comparable<Order> {
    @NotNull(message = "Id is required")
    private int id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Min(value = 1, message = "Volume must be greater than 0")
    private int volume;

    @Min(value = 1, message = "Price must be greater than 0")
    private long price;

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.id, o.id);
    }
}
