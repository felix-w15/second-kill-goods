package com.felix.backstage.entity;

import java.util.ArrayList;
import java.util.List;

public class NavigationTree {
    private Navigation mynav;
    private List<NavigationTree> children;

    public NavigationTree(Navigation mynav, List<NavigationTree> children) {
        this.mynav = mynav;
        this.children = children;
    }

    public NavigationTree(Navigation mynav) {
        this.mynav = mynav;
        this.children = new ArrayList<>();
    }


    public List<NavigationTree> getChildren() {
        return children;
    }

    public void setChildren(List<NavigationTree> children) {
        this.children = children;
    }

    public Navigation getMynav() {
        return mynav;
    }

    public void setMynav(Navigation mynav) {
        this.mynav = mynav;
    }

}
