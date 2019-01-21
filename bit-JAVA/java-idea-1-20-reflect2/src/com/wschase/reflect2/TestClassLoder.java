package com.wschase.reflect2;

/**反射（下）
 * Author:WSChase
 * Created:2019/1/20
 */
public class TestClassLoder {
    public static void main(String[] args) {
        Class classz=TestClassLoder.class;//Class类的对象
        System.out.println(classz.getClassLoader());//类加载器
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
    }
}
