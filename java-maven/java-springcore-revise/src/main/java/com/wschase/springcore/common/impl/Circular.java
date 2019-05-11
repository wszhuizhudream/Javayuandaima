package com.wschase.springcore.common.impl;

import com.wschase.springcore.common.Shape;

/**圆形
 * Author:WSChase
 * Created:2019/5/4
 */
public class Circular implements Shape {
    //计算圆形的面积我们自需要半径
    private final double radius;


    public Circular(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }


    public double computeArea() {
        return Math.PI*Math.pow(radius,2);
    }

    public double computeSide() {
        return 2*Math.PI*radius;
    }
}
