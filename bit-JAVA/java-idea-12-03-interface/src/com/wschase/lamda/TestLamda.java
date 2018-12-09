package com.wschase.lamda;

/**
 * Author:WSChase
 * Created:2018/12/3
 */
//1.面向对象编程
//interface IMessage{
//    public void print();
//}
//public class TestLamda {
//    public static void main(String[] args) {
//        //这是我们传统的面向对象的编程——>匿名对象实现接口并且创建对象
//        IMessage message=new IMessage() {
//            @Override
//            public void print() {
//                System.out.println("这是接口中的抽象方法");
//            }
//        };
//        message.print();
//    }
//}


////2.函数式编程
//interface IMessage{
//    public void print();
//}
//public class TestLamda{
//    public static void main(String[] args) {
//        //函数式编程实现与上面一样的功能
//        IMessage message= () -> System.out.println("这是接口中的抽象方法");
//        message.print();
//    }
//}

//////单行语句：
////interface IMessage{
////    public void print();
////}
////public class TestLamda{
////    public static void main(String[] args) {
////        //函数式编程实现与上面一样的功能
////        IMessage message= () -> System.out.println("这是接口中的抽象方法");
////        message.print();
////    }
////}
////多行语句：
////2.函数式编程
//    @FunctionalInterface
//interface IMessage{
//    public void print();
//}
//public class TestLamda{
//    public static void main(String[] args) {
//        //函数式编程实现与上面一样的功能
//        IMessage message= () -> {
//            System.out.println("这是接口中的抽象方法");
//            System.out.println("Hello World");
//        };
//        message.print();
//    }
//}

////直接进行计算
//@FunctionalInterface
//interface IMath{
//    public int add(int x,int y);
//}
//public class TestLamda{
//    public static void main(String[] args) {
//        //函数是编程的使用，还是输出一句话
//        IMath msg= (p1, p2) -> p1+p2;
//        System.out.println(msg.add(10,20));
//    }
//}