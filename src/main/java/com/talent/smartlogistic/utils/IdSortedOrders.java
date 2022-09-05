package com.talent.smartlogistic.utils;

import java.io.Serial;
import java.util.LinkedList;
import java.util.ListIterator;

public class IdSortedOrders<Order extends Comparable<Order>> extends LinkedList<Order> {

    @Serial
    private static final long serialVersionUID = 1L;

    public boolean orderedAdd(Order element) {
        ListIterator<Order> itr = listIterator();
        while(true) {
            if (!itr.hasNext()) {
                itr.add(element);
                return(true);
            }

            Order elementInList = itr.next();
            if (elementInList.compareTo(element) > 0) {
                itr.previous();
                itr.add(element);
                System.out.println("Adding");
                return(true);
            }
        }
    }
}

