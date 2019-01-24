package com.wschase.reflect4;

import java.lang.reflect.Method;

/**4.1认识ClassLoader
 * public ClassLoader getClassLoader();//通过getClassLoader()方法调用后返回的是ClassLoader
 * Author:WSChase
 * Created:2019/1/23
 */
class Member{}
public class TestReflect41 {
    public static void main(String[] args) {
        Class<?> cls=Member.class;
        System.out.println(cls.getClassLoader());//cls的ClassLoader
        System.out.println(cls.getClassLoader().getParent());//cls的ClassLoader的父类也是ClassLoader
        System.out.println(cls.getClassLoader().getParent().getParent());//cls的ClassLoader的父类的父类为null

    }

}
