package com.wschase.liu;

import java.io.Serializable;

/**
 * Author:WSChase
 * Created:2018/12/9
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name="+name+",age="+age+"]";
    }
}
