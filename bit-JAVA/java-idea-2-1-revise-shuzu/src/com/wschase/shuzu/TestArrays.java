package com.wschase.shuzu;

/**[擅长]第二篇——数组
 * 下面主要讲解数组的初始化、赋值、循环
 * Author:WSChase
 * Created:2019/2/1
 */
public class TestArrays {

    public static void main(String[] args) {
        int[] x=null;//声明数组
        int[] temp=null;//声明数组
        x=new int[]{1,2,3,4,5};//开辟空间
        //首先直接输出赋值后的数组元素
        System.out.println("这是没有经过改变的数组的值");
        for(int i=0;i<x.length;i++){
        System.out.println(x[i]);//因为它是引用数据类型，所以想要直接通过对象名输出值需要覆写toString方法
        }

        //其次，经过引用传递改变这个数组的值，观察原来的数组是否改变
        temp=x;//引用传递——经过引用传递以后temp和x指向同一个堆内存空间
        temp[3]=10;//改变temp这个数组里面的元素值
        System.out.println("这是通过引用传递以后另外一个数组的值发生改变：");
        for(int i=0;i<temp.length;i++){
            System.out.println(temp[i]);
        }

        System.out.println("经过改变以后原来数组是否发生改变：");
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }

        //通过观察我们发现当改变另外一个数组的值的时候原来哪个数组里面的元素值也是发生了改变的
        //原因是：它们两个栈内存指向的是同一个堆内存，一个改变另一个自然也是改变的

    }
}
