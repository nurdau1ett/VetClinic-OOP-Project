package com.nurdaulet.vetclinic;

public abstract class Person {


    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public abstract void work();

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
