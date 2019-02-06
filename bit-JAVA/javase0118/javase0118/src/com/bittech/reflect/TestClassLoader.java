package com.bittech.reflect;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestClassLoader {
    
    public static void main(String[] args) {
        
        Class classz = TestClassLoader.class; //Class类的对象
        System.out.println(classz.getClassLoader());//类加载器
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
        
    }
}
