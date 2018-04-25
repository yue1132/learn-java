package com.base.copyObject;

public class Student {
    private String number;

    public String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                '}';
    }
}
