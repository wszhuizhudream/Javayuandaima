package com.wschase.spring.common.impl;

import com.wschase.spring.common.Shape;

/**
 * Author:WSChase
 * Created:2019/4/17
 */
public class Rectangle implements Shape {
    //宽
    private final double width;

    private final double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //高
    public double computeArea() {
        return this.getWidth()*this.getHeight();
    }

    public double computeSide() {
        return 2*(this.getHeight()+this.getWidth());
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ",area="+this.computeArea()+
                ",side="+this.computeSide()+
                '}';
    }
}
