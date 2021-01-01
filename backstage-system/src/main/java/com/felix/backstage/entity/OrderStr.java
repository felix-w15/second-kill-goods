package com.felix.backstage.entity;

public class OrderStr {
    private String customerName;
    private String goodName;

    public OrderStr(String customerName, String goodName) {
        this.customerName = customerName;
        this.goodName = goodName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
