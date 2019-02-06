package com.bittech.reflect.classloader;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
public class TestMyClassLoader {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        /**
         * 自定义类加载器
         */
        System.out.println("自定义类加载器加载Member");
        MyClassLoader classLoader = new MyClassLoader();
        Class classes = classLoader.loadData("com.bittech.reflect.classloader.Member");
        System.out.println(classes);//com.bittech.reflect.classloader.Member
        System.out.println(classes.getClassLoader());//MyClassLoader
        System.out.println(classes.getClassLoader().getParent());//AppClassLoader
        System.out.println(classes.getClassLoader().getParent().getParent());//ExtClassLoader
        System.out.println(classes.getClassLoader().getParent().getParent().getParent());//Bootstrap null
        
        System.out.println("系统类加载器加载Member");
        Class classes2 = com.bittech.reflect.classloader.Member.class;
        System.out.println(classes2);//com.bittech.reflect.classloader.Member
        System.out.println(classes2.getClassLoader());//APP
        System.out.println(classes2.getClassLoader().getParent());
        System.out.println(classes2.getClassLoader().getParent().getParent());
        
        System.out.println("两个Class对象是否相等");
        System.out.println(classes == classes2);//false
    }
}
