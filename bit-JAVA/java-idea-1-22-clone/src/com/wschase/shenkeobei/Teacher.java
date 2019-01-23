package com.wschase.shenkeobei;

import java.io.Serializable;

/**
 * Author:WSChase
 * Created:2019/1/22
 */
public class Teacher implements Serializable {
    private String nane;

    private String direction;

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Teacher(String nane, String direction) {
        this.nane = nane;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "nane='" + nane + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
