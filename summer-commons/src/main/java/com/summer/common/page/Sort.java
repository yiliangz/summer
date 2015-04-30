package com.summer.common.page;

import org.hibernate.criterion.Order;

import java.util.List;

/**
 * Created by Allen on 2015/4/27.
 */
public class Sort {

    private String field;

    private Order order;

    public enum Order {
        ASC,DESC
    }

    public Sort() {}

    public Sort(String field, Order order) {
        this.field = field;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Order getOrder() {
        return order;
    }

    public void setDirection(Order direction) {
        this.order = order;
    }

    public org.hibernate.criterion.Order getHibernateOrder() {
        if (this.order != null && this.order.equals(Order.DESC)) {
            return org.hibernate.criterion.Order.desc(field);
        } else {
            return org.hibernate.criterion.Order.asc(field);
        }
    }
}
