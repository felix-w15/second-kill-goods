package com.felix.backstage.entity;

public class Navigation {
    private int navId;
    private String navName;
    private int parentId;
    private String navURL;
    private int listorder;

    public Navigation(int navId, String navName, int parentId, String navURL, int listorder) {
        this.navId = navId;
        this.navName = navName;
        this.parentId = parentId;
        this.navURL = navURL;
        this.listorder = listorder;
    }


    public int getNavId() {
        return navId;
    }

    public void setNavId(int navId) {
        this.navId = navId;
    }

    public String getNavName() {
        return navName;
    }

    public void setNavName(String navName) {
        this.navName = navName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getNavURL() {
        return navURL;
    }

    public void setNavURL(String navURL) {
        this.navURL = navURL;
    }

    public int getListorder() {
        return listorder;
    }

    public void setListorder(int listorder) {
        this.listorder = listorder;
    }
}
