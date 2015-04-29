package com.summer.common.page;

/**
 * Created by Allen on 2015/4/27.
 */
public class Order {

    private String field;

    private Direction direction;

    public enum Direction {
        ASC,DESC
    }

    public Order(String field,Direction direction) {
        this.field = field;
        this.direction = direction;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
