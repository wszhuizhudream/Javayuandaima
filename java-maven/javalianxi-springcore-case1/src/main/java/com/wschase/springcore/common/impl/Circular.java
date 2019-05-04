package com.wschase.springcore.common.impl;

import com.wschase.springcore.common.Shape;

/**圆
 * Author:WSChase
 * Created:2019/5/2
 */
public class Circular implements Shape {
    //对于final类型的变量就没有set方法了
    private final double radius;

    public Circular(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double computeArea() {
        return Math.PI*Math.pow(this.getRadius(),2);
    }

    public double computeSide() {
        return 2*Math.PI*this.getRadius();
    }
}
