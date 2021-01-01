package com.felix.backstage.entity;

public class Log {
    private int id;
    private String url;
    private String time;
    private String username;

    public Log(int id, String url, String time, String username) {
        this.id = id;
        this.url = url;
        this.time = time;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
