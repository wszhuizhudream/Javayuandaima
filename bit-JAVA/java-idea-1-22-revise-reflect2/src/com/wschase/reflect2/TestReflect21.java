package com.wschase.reflect2;

/**2.1反射与类操作
 * Author:WSChase
 * Created:2019/1/22
 */
public class TestReflect21 {
    public static void main(String[] args) {
        //1.取得父类信息
        //（1）取得包名
        Class<?> cl=TestReflect21.class;//取得Class类对象
        System.out.println(cl.getPackage().getName());//取得包然后再取得它的名字


        //（2）取得父类（实现的父接口）

        //取得父类名称：因为类是单继承，所以接收类只用一个对象就可以了。
        System.out.println(cl.getSuperclass().getName());

        //取得实现的父接口对象:因为接口可以多实现，所以得到的父接口用数组接收
        Class<?>[] iClass=cl.getInterfaces();
        for(Class<?> c:iClass){
            System.out.println(c.getName());
        }

    }
}


