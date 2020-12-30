package com.myweb.miaosha.entity;

public class Order {
    private int orderId;
    private int goodId;
    private int customerId;

    public Order(int orderId, int goodId, int customerId) {
        this.orderId = orderId;
        this.goodId = goodId;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
