package com.bittech.sthrow;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 小结一下：异常需要掌握的东西
 * 1.什么是异常：异常就是我们的程序在执行过程中会遇到的一些问题，但它是可以避免的，它和错误不同，可以规避。
 * 2.异常的处理格式：try{}catch(){}finally{}
 * 3.throws和throw的区别:前者是方法中用到的抛出异常的关键字，只用了它方法中可以不处理异常；后者是由我们自己产生一个异常的对象。
 * 4.检查异常和运行时异常的区别：检查异常（IOException）它在程序中是必须要进行处理的异常，否则编译就不能通过，如果我们在前面所有的地方
 * 都不进行处理，那么在main方法中也需要进行处理，如果在main方法中也不处理就是JVM处理，它直接关掉。但是我们的运行时异常(RuntimeException)
 * 可以不对它进行处理。
 * Author:WSChase
 * Created:2018/11/28
 */
public class Throw1 {
//    public static void code1(){
//        System.out.println("计算开始");
//        try {
//            System.out.println(10 / 0);
//        } finally {
//            System.out.println("异常处理结束");
//        }
//        System.out.println("计算结束");
//    }
//    public static void code2(){
//        //计算两个数的除法->处理异常，取得异常信息
//        System.out.println("计算开始");
//        try {
//            System.out.println("计算中：" + 10 / 0);
//        } catch (ArithmeticException e) {
//            e.printStackTrace();//获取异常信息
//        }
//        System.out.println("计算结束");
//    }
//public static void code3(){
//    //采用初始化参数进行数学运算
//    System.out.println("1.计算开始");
//    try {
//        Integer x = Integer.parseInt(args[0]);//字符串转化为整数
//        Integer y = Integer.parseInt(args[1]);
//        System.out.println("2.进行计算：" + x / y);
//    } catch (ArithmeticException e) {//除数为0
//        e.printStackTrace();
//    } catch (NumberFormatException e){//输入的不是数字
//        e.printStackTrace();
//    }catch (ArrayIndexOutOfBoundsException e){//数组下标越界（没有给参数）
//        e.printStackTrace();
//    }
//    finally {
//        System.out.println("不管是否产生异常都会执行这个语句");
//    }
//    System.out.println("计算结束");
//
//}
public static void code4(){
    try{
        System.out.println(calculate(10,0));//调用存在异常的这个方法，那么就需要处理这个异常
    }catch(Exception e){
        e.printStackTrace();
    }
}
    public static int calculate(int x,int y) throws Exception{//在这个方法中只进行了抛出异常
        return x/y;
    }
    public static void main(String[] args) {
    try{
        throw new Exception("抛出异常");
    }catch(Exception e){
        e.printStackTrace();
        }
    }
}

