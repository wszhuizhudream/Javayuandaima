package com.wschase.spring.common.impl;

import com.wschase.spring.common.Shape;

/**三角形
 * Author:WSChase
 * Created:2019/4/17
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
        double s=Math.sqrt(
                (q-a)*(q-b)*(q-c)*q
        );
        return 0;
    }

    public double computeSide() {
        return this.getA()+this.getB()+this.getC();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ",area="+this.computeArea()+
                ",side="+this.computeSide()+
                '}';
    }
}
