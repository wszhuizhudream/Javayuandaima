package com.wschase.spring.common.impl;


import com.wschase.spring.common.Shape;

/**
 * Author:WSChase
 * Created:2019/4/17
 */
public class Circular implements Shape {
    private final double radius;

    public Circular(double radius) {
        this.radius = radius;
    }

    public double computeArea() {
        return Math.PI*Math.pow(this.getRadius(),2);
    }

    public double computeSide() {
        return 2*Math.PI*this.getRadius();
    }


    //fianl类型只有set方法
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circular{" +
                "radius=" + radius +
                ",area="+this.computeArea()+
                ",side="+this.computeSide()+
                '}';
    }
}
