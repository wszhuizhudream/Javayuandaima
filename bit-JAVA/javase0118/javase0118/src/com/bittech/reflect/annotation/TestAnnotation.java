package com.bittech.reflect.annotation;

import java.lang.annotation.Annotation;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
@Deprecated
@SuppressWarnings(value = {"serial"})
public class TestAnnotation {
    
    
    @Deprecated
    @Override
    public String toString() {
        return super.toString();
    }
    
    public static void main(String[] args) throws NoSuchMethodException {
        Class classz = TestAnnotation.class;
//        Annotation[] annotations = classz.getAnnotations();
        //2
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation);
//        }
//
//        Annotation annotation = classz.getAnnotation(Deprecated.class);
//        System.out.println(annotation);
        
        for (Annotation annotation : classz.getMethod("toString").getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
