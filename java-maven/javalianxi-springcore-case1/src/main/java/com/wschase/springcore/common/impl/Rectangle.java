package com.wschase.springcore.common.impl;

import com.wschase.springcore.common.Shape;

/**长方形
 * Author:WSChase
 * Created:2019/5/2
 */
public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double computeArea() {
        return this.getHeight()*this.getWidth();
    }

    public double computeSide() {
        return 2*(this.getWidth()+this.getHeight());
    }
}
