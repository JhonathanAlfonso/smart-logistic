package com.talent.smartlogistic.model;

import com.talent.smartlogistic.validator.UniqueId;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
public class Order implements Comparable<Order> {
    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be greater than 0")
    @UniqueId
    private Integer id;

    @NotBlank(message = "customerName is required")
    private String customerName;

    @Min(value = 1, message = "volume must be greater than 0")
    private int volume;

    @Min(value = 1, message = "price must be greater than 0")
    private long price;

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.id, o.id);
    }
}
