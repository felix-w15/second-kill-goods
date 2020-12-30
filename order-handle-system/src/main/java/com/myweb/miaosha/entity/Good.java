package com.myweb.miaosha.entity;

public class Good {
    private int id;
    private String goodName;
    private int goodTotalNum;
    private int goodRemainNum;

    public Good(int id, String goodName, int goodTotalNum, int goodRemainNum) {
        this.id = id;
        this.goodName = goodName;
        this.goodTotalNum = goodTotalNum;
        this.goodRemainNum = goodRemainNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodTotalNum() {
        return goodTotalNum;
    }

    public void setGoodTotalNum(int goodTotalNum) {
        this.goodTotalNum = goodTotalNum;
    }

    public int getGoodRemainNum() {
        return goodRemainNum;
    }

    public void setGoodRemainNum(int goodRemainNum) {
        this.goodRemainNum = goodRemainNum;
    }
}
