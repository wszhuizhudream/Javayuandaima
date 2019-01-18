package com.wschase.fanxing;

/**泛型擦出：
 * 在JVM里面，泛型类和普通类是一样的，没有区别，所以我们的泛型只存在于代码的编译阶段
 * 在进入JVM之前都会被擦出的。
 * Author:WSChase
 * Created:2019/1/16
 */

class MyClass<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
public class TestCachu {
    public static void main(String[] args) {
        MyClass<String> myClass1=new MyClass<>();
        MyClass<Integer> myClass2=new MyClass<>();
        System.out.println(myClass1.getClass() == myClass2.getClass());
    }

}
