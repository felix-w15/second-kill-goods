package com.myweb.miaosha.entity;

import java.io.Serializable;

public class SecKillMsg implements Serializable {
    private int customerId;
    private int goodId;

    @Override
    public String toString() {
        return "SecKillMsg{" +
                "customerId=" + customerId +
                ", goodId=" + goodId + '}';
    }


    public SecKillMsg(int customerId, int goodId) {
        this.customerId = customerId;
        this.goodId = goodId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }


}
