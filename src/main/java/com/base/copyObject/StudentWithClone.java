package com.base.copyObject;

public class StudentWithClone implements Cloneable {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                '}';
    }

    @Override
    public Object clone(){

        StudentWithClone stu = null;
        try {
            stu = (StudentWithClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }

}
