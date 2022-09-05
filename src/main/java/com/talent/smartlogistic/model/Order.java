package com.talent.smartlogistic.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Order implements Comparable<Order> {
    private int id;
    private String customerName;
    private int volume;
    private long price;

    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.id, o.id);
    }
}
