package com.java8;

public class PersonTest {
    public static void main(String[] args){

        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        System.out.println(person);

    }
}
