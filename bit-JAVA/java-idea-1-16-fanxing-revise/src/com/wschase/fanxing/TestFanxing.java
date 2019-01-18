package com.wschase.fanxing;

/**泛型：
 * 1.泛型类
 * 2.泛型方法
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestFanxing {
    public <T> T testMethod(T t){//这是放行方法规定的写法
        return t;
    }

    public static void main(String[] args) {
        //调用泛型方法:调用泛型方法的时候只要用包装类型指明方法类型就可以了
        TestFanxing t1=new TestFanxing();
        Integer i=t1.testMethod(100);
        System.out.println(i);
    }
}
