package com.base.copyObject;

/**
 * 对象的复制
 */
public class CoypObject {

    public static void main(String[] args){

        Student stu1 = new Student();
        stu1.setNumber("12345");
        Student stu2 = stu1;

        System.out.println("stu1:" +stu1);
        System.out.println("stu2:" +stu2);

        stu2.setNumber("54321");
        System.out.println("==================");
        System.out.println("stu1:" +stu1);
        System.out.println("stu2:" +stu2);


        System.out.println("=======+++++++++++++++++++===========");

        StudentWithClone student1 = new StudentWithClone();
        student1.setNumber("112233");
        StudentWithClone student2 = (StudentWithClone) student1.clone();

        System.out.println("student1:" + student1);
        System.out.println("student2:" + student2);

        student2.setNumber("332211");

        System.out.println("==================");

        System.out.println("student1:" + student1);
        System.out.println("student2:" + student2);
    }
}
