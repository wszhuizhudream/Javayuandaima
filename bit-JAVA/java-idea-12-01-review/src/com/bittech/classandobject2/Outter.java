package com.bittech.classandobject2;

/**内部类：非常重要，面试经常问到
 * Author:WSChase
 * Created:2018/12/1
 */
//内部类：定义在另一个类中的类。为什么需要内部类呢，我们主要分为以下三点进行说明:
    //(1)通过内部类我们可以访问到该类所在的作用域的所有数据，包括私有数据。
    //(2)内部类可以对同一个包中的其他类进行隐藏（就是只能在这个类中进行访问，在其他类中不允许访问）
    //(3)当我们想要定义一个回调函数并且不希望写大量代码的时候我们就可以采用匿名内部类。
//对于内部类的分类：从大的方面来分，内部类又分为两类：
    //（1）非静态内部类：成员内部类、方法内部类、匿名内部类
    //（2）静态内部类
//我们将内部类分为这两个大类后需要明确的是，非静态内部类创建对象需要先依赖外部类创建的对象；但是静态内部类创建对象不需要
//依赖外部类创建的对象。

//定义一个接口
interface MyInterface{
    void test();
}
public class Outter {
    private String msg = "这是外部类的私有属性";

    public String getMsg() {
        return msg;
    }
    // //（1）成员内部类
////成员内部类就像是普通类一样
//    class Inner {
//
//    public Inner() {
//        System.out.println("这是成员内部类");
//        System.out.println(msg);//在成员内部类里面访问外部类的私有属性
//    }
//    public void fun(){
//        Inner in=new Inner();//在内部类里面创建内部类的对象
//    }
//}
//
//public static void main(String[] args) {
//        //在外部类里面创建成员内部类的对象:我们需要知道的是成员内部类的内名是：外部类.内部类
//        Outter.Inner inner=new Outter().new Inner();
//        inner.fun();//通过内部类创建的对象访问内部类的方法
//    }

////（2）方法内部类（局部内部类）：定义在方法中的内部类。方法内部类和成员内部类的使用规则是相同的，唯一的区别就是方法
//    //内部类只能在一个方法中有效，方法外是不让访问的。
//    public void fun(){
//        int x=3;
//        class Inner{
//            public Inner(){
//                System.out.println("这是方法内部类的构造方法");
//                System.out.println(x);
//            }
//            public void print(){
//                System.out.println("这是方法内部类");
//            }
//        }
//        //这个是外部类的一个方法专门用来访问这个方法中的内部类
//                Inner inner=new Inner();
//                inner.print();
//    }
//
//    public static void main(String[] args) {
//        //在外部类里面创建方法内部类的对象->error---->在方法内部类中我们只能在它的这个方法里面对它进行访问，超出这个方法它
//        //是对外隐藏的。
//       // Outter.Inner inner1=new Outtre().new Inner();//error
//       // inner1.fun();//error
//        Outter out=new Outter();
//        out.fun();
//    }
//（3）匿名内部类:将局部内部类的使用再深入一步。如果我们只需要创建这个类的一个对象，就不需要命名了。
//匿名内部类也是定义在方法中的内部类，并且必须实现一个接口或者继承一个抽象类。
//内部类通常的语法：
//new SunperType(construction parameters){
//    inner class methods and data
//    }
//其中SunperType可以是接口，于是内部类里面就要实现这个接口；也可以是一个抽象类，于是内部类里面就要对这个抽象类进行给扩展
public void fun(String msg){
    new MyInterface(){//创建一个有匿名内部类像接口转型的对象
        @Override
        public void test(){
            System.out.println("这是接口的方法");
        }
    }.test();//定义一个匿名内部类去创建接口的对象并且实现接口中的抽象方法。然后用这个对象调用接口中的方法
}

    public static void main(String[] args) {
        Outter out=new Outter();
        out.fun(out.getMsg());
    }



////（4）静态内部类：有时候我们使用内部类只是为了把一个类隐藏在另一个类的内部，并不需要这个内部类引用然和外部类对象，
////这时候我们用static修饰这个类就可以达到我们的要求。
//    static class Inner{//在静态内部类中不可以访问外部类的非静态属性以及非静态方法
//        public Inner(){
//            System.out.println("这是静态内部构造类");
//        }
//        public void print(){
//            System.out.println("这是静态内部类");
//        }
//        public void fun(){
//            //在静态内部类里面创建静态内部类的方法
//            Inner inner=new Inner();
//            inner.print();
//        }
//}
//
//    public static void main(String[] args) {
//        //在外部类里面创建静态内部类对象
//        Outter.Inner inner1=new Outter.Inner();
//        inner1.fun();//内部类对象调用内部类的属性
//    }


}
