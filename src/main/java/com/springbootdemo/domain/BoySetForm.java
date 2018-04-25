package com.springbootdemo.domain;

import java.util.Set;

public class BoySetForm {

    private Set<Boy> boys;

    public Set<Boy> getBoys() {
        return boys;
    }

    public void setBoys(Set<Boy> boys) {
        this.boys = boys;
    }

    @Override
    public String toString() {
        return "BoySetForm{" +
                "boys=" + boys +
                '}';
    }
}
