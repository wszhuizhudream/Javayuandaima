package com.wschase.springcore.common.impl;

import com.wschase.springcore.common.Shape;

/**长方形
 * Author:WSChase
 * Created:2019/5/4
 */
public class Rectangle implements Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double computeArea() {
        return height*width;
    }

    public double computeSide() {
        return 2*(height+width);
    }
}
