package com.wschase.spring.xml;

import com.wschase.spring.common.Shape;

/**
 * Author:WSChase
 * Created:2019/4/17
 */
public class XmlShapeCompute {

    public Shape  circular;

    public Shape triangle;

    public Shape rectangle;

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
            throw new IllegalArgumentException("Not found shape");
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
        throw new IllegalArgumentException("Not found shape"+shapeName);
    }

}
