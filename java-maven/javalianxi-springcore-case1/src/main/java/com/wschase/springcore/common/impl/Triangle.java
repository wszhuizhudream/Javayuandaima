package com.wschase.springcore.common.impl;

import com.wschase.springcore.common.Shape;

/**
 * Author:WSChase
 * Created:2019/5/2
 */
public class Triangle implements Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double computeArea() {
        double q=(this.computeSide())/2;
        double s=Math.sqrt((q-a)*(q-b)*(q-c)*q);
        return s;
    }

    public double computeSide() {
        return this.getA()+this.getB()+this.getC();
    }
}
