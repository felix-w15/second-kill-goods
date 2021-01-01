package com.felix.backstage.entity;

public class Order {
    private int order_id;
    private int good_id;
    private int customer_id;

    public Order(int order_id, int good_id, int customer_id) {
        this.order_id = order_id;
        this.good_id = good_id;
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
