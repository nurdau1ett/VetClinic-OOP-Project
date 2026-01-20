package com.nurdaulet.vetclinic;

public class Person {


    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void work() {
        System.out.println(name + " is doing general work.");
    }

    public String getRole() {
        return "Person";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    @Override
    public String toString() {
        return "[PERSON] Name: " + name + ", Age: " + age;
    }
}
