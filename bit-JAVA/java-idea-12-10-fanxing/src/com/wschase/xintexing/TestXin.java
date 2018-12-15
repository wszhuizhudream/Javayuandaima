package com.wschase.xintexing;

import java.io.InputStreamReader;

/**
 * Author:WSChase
 * Created:2018/12/10
 */
//public class TestXin {
////    //1.方法的可变参数
////    private static int add(int ... data) {//其实可变参数本质上还是数组
////        int result=0;
////        //正是因为可变参数的本质还是数组，所以我们下面的处理还是用数组来处理的
////        for(int i=0;i<data.length;i++){
////            result +=data[i];
////        }
////    return result;
////    }
//     //2.传递多类参数
//    public static int add(String msg,int ... data){
//        int result=0;
//        for(int i=0;i<data.length;i++){
//            result +=data[i];
//        }
//        return result;
//    }
//    public static void main(String[] args) {
////        //1.方法的可变参数
////        System.out.println(add(1,4,5,6));
////        System.out.println(add(new int[]{1,2,3}));
////        System.out.println(add(new int[]{1,2,3,4,5,6}));
//
////        //2.传递多类参数
//        System.out.println(add("hello"));
//        System.out.println(add("hello",1,4,5));
//        System.out.println(add("he",new int[]{1,2,3}));
//    }
//
//}



////2.foreach循环
//public class TestXin{
//    public static void main(String[] args) {
//        int[] data=new int[]{1,2,3,4,5};
//        for(int i:data){//在这是将数组中元素的值赋给了临时变量i
//            System.out.println(i);//在这我们使用数组中与那素赋值直接使用临时变量赋值就可以了
//        }
//    }
//}



////3.使用类型参数做返回值的泛型方法
//class MyClass{
//    public <T> T testMethod(T t){
//        return t;
//    }
//}

////4.泛型方法和泛型类是共存的
//class MyClass<T> {
//    public <T> void testMethod1(T t) {
//        System.out.println(t);
//    }
//
//    public <T> T testMethod2(T t) {
//        return t;
//    }
//}
//public class TestXin{
//    public static void main(String[] args) {
//        MyClass<String> myClass= new MyClass<>();//在后面这个<>里面可以不要参数类型
//        myClass.testMethod1("这是泛型类中的泛型方法");
//        Integer i=myClass.testMethod2(100);
//        //由于上面传入的是100，所以返回的类型T也就是100了。
//        System.out.println(i);
//    }
//}

//泛型的几种情况
//    3.泛型的几种情况
//            （1）泛型类里面只有普通方法
    class Person<T>{
        private T name;
        private T age;
        //泛型类中没有参数的普通方法
        public void getInfo(){

        }
        //泛型类中有参数的普通方法
        public void fun(T t){
            System.out.println("t="+t);
        }
}
//            （2）普通类里面只有泛型方法
    class Person1{
        private String name;
         private int age;
         //普通类中的泛型方法:注意泛型方法是需要在返回值类型前面有类型声明（占位）的
    public <E> void fun1(E e){
        System.out.println("e="+e);
    }
         //普通类中有返回值的泛型方法
    public <E> E fun2(E e){
        return e;
    }

}
//            （3）泛型类里面既有泛型方法又有普通方法
class Person3<T>{
        private T name;
        private T age;
    //下面这些都是普通方法
    public Person3(T name) {
        this.name = name;
    }

    public Person3(T name, T age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
    //泛型方法
    public <E> void fun1(E e){
        System.out.println("e="+e);
    }
    //注意：下面的这个方法返回类型和传参类型之所以一样，是因为返回值类型是由传递的参数类型决定的，这样的话类型肯定是一样的。
    public <E> E fun2(E e){
        return e;
    }
}
public class TestXin{
    public static void main(String[] args) {

    }
}















