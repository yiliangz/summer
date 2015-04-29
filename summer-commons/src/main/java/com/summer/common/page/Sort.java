package com.summer.common.page;

import java.util.List;

/**
 * Created by Allen on 2015/4/27.
 */
public class Sort {

    private List<Order> orders;

    public Sort(List<Order> orders) {
        this.orders = orders;
    }

    public void add(Order order) {
        orders.add(order);
    }

}
