package com.springbootdemo.domain;

import java.util.Map;

public class BoyMapForm {

    private Map<String, Boy> boys;

    public Map<String, Boy> getBoys() {
        return boys;
    }

    public void setBoys(Map<String, Boy> boys) {
        this.boys = boys;
    }

    @Override
    public String toString() {
        return "BoyMapForm{" +
                "boys=" + boys +
                '}';
    }
}
