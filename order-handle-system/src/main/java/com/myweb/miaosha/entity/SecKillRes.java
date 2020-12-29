package com.myweb.miaosha.entity;

public class SecKillRes {

    private int code;
    private String status;

    public SecKillRes(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public SecKillRes() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
