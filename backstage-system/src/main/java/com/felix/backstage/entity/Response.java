package com.felix.backstage.entity;

public class Response {
    private int code;
    private String status;

    public Response(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public Response() {
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
