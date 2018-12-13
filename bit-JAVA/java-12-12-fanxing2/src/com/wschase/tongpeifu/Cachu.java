package com.wschase.tongpeifu;

/**擦出
 * Author:WSChase
 * Created:2018/12/12
 */
//class Myclass<T>{
//    private T message;
//
//    public T getMessage() {
//        return message;
//    }
//
//    public void setMessage(T message) {
//        this.message = message;
//    }
//    public void testMethod(T t){
//        System.out.println(t);
//    }
//}
//public class Cachu {
//    public static void main(String[] args) {
//        Myclass<String> m1=new Myclass<>();
//        Myclass<Integer> m2=new Myclass<>();
//        System.out.println(m1.getClass()==m1.getClass());
//    }
//}
//


//泛型类型擦出
class MyClass<T>{
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
    public void fun(T t){
        System.out.println(t);
    }
}