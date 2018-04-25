package com.springbootdemo.domain;

import java.util.List;

public class BoyListForm {

    private List<Boy> boys;

    public List<Boy> getBoys() {
        return boys;
    }

    public void setBoys(List<Boy> boys) {
        this.boys = boys;
    }

    @Override
    public String toString() {
        return "BoyListForm{" +
                "boys=" + boys +
                '}';
    }
}
