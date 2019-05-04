package com.wschase.springcore.xml;

import com.wschase.springcore.common.Shape;
import com.wschase.springcore.common.impl.Circular;
import com.wschase.springcore.common.impl.Rectangle;
import com.wschase.springcore.common.impl.Triangle;

/**
 * Author:WSChase
 * Created:2019/5/2
 */
public class XmlShapeCompute {
    private Shape circular;

    private Shape triangle;

    private Shape rectangle;

    public Shape getCircular() {
        return circular;
    }

    public void setCircular(Shape circular) {
        this.circular = circular;
    }

    public Shape getTriangle() {
        return triangle;
    }

    public void setTriangle(Shape triangle) {
        this.triangle = triangle;
    }

    public Shape getRectangle() {
        return rectangle;
    }

    public void setRectangle(Shape rectangle) {
        this.rectangle = rectangle;
    }

    public Shape computeShape(String shapeName){
        if(shapeName==null||shapeName.length()==0){
            throw new IllegalArgumentException("Not Found");
        }
        if(shapeName.equals("circular")){
            return circular;
        }
        if(shapeName.equals("triangle")){
            return triangle;
        }
        if(shapeName.equals("rectangle")){
            return rectangle;
        }
        throw new IllegalArgumentException("Not Found");
    }

}
