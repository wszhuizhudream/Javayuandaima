package com.bittech.code;

/**
 * 代码块：普通代码块、构造块、静态代码块
 * Author:WSChase
 * Created:2018/11/28
 */
public class Code {
//    //1.普通代码块：放在方法中的代码块，可以让这个方法中的某个变量重复定义
//    public static void main(String[] args) {
//        //普通代码块：下面可以多次定义变量x;
//        // 还需要注意的是如果代码块中定义了一个和外边相同的变量，这个时候我们的代码块应该写在前面，
//        //如果写在后面就使效了。
//        {
//            int x=20;
//            System.out.println("x="+x);
//        }
//        int x=10;
//        System.out.println("x="+x);
//    }

//    //2.构造块:构造块是在类中的代码块
//    //对于构造块，它要先于构造方法执行，并且创建多少个对象就会执行多少次
//        //构造块
//        {
//            System.out.println("这是构造块");
//        }
//
//    public Code() {
//        System.out.println("这是构造方法");
//    }
//
//    public static void main(String[] args) {
//        Code c1=new Code();//创建对象就会调用构造函数以及构造块
//        Code c2=new Code();
//    }


//    //3.静态块：用static修饰的代码块，它只能放在类中不可以放在方法中。并且静态块不管创建多少个对象它都只
//    // 执行一次，因为它的实现机理是我们的JVM在加载类之前进行加载的。所以它只加载一次。
//    static{
//        System.out.println("这是静态块");
//    }
//    {
//        System.out.println("这是构造块");
//    }
//
//    public Code() {
//        System.out.println("这是构造方法");
//    }
//
//    public static void main(String[] args) {
//        Code c1=new Code();
//        Code c2=new Code();
//    }
}
