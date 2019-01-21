package com.wschase.annotation;

/**取得某个具体的Annotation
 * Author:WSChase
 * Created:2019/1/20
 */

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 取得某个指定的Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    public String name() default "张三";
    public int age() default 20;
}

@Deprecated
@MyAnnotation2
//这个就是自定义的Annotation的注解
class Member4 implements Serializable{}
public class TestAnnotation4 {
    public static void main(String[] args) {
        MyAnnotation1 ma= Member4.class.getAnnotation(MyAnnotation1.class);
        System.out.println("姓名："+ma.name());
        System.out.println("年龄："+ma.age());
    }
}
