package com.springbootdemo.domain;

public class Boy {

    private Float height;

    private Integer age;


    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boy boy = (Boy) o;

        if (!height.equals(boy.height)) return false;
        return age.equals(boy.age);
    }

    @Override
    public int hashCode() {
        int result = height.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "height=" + height +
                ", age=" + age +
                '}';
    }
}
