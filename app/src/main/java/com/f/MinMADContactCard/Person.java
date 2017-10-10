package com.f.MinMADContactCard;

import java.io.Serializable;

/**
 * Created by ferdinand on 10-10-2017.
 */

public class Person implements Serializable{
    int id;
    String name;
    int age;

    public Person(){

    }

    public Person(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}