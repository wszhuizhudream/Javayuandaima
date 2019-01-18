package com.wschase.xintexing;

/**新特性：
 * 1.可变参数
 * 2.foreach循环
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestNew {

        //1.方法的可变参数
    public static void code1(){
        System.out.println(add(1,2,3,4));//随意传递内容
        System.out.println(add(new int[]{1,2,3,4}));//可变参数可以接收数组
        System.out.println("---------------");
        System.out.println(add("hello",new int[]{1,2,3,4,5}));

    }

    //（1）只传递一个参数（可变参数）可变参数的方法
    public static int add(int ... data){
        int result=0;
        for(int i=0;i<data.length;i++){
            result +=data[i];
        }
        return result;
    }

    //（2）传递多累参数：可变参数一定更要放在最后，并且只能设置一个可变参数
    public static int add(String msg,int ... data){
        int result=0;
        for(int i=0;i<data.length;i++){
            result+=data[i];
        }
        return result;

    }
    public static void main(String[] args) {
        //foreach循环的使用
        int[] A=new int[]{1,2,3,4,5};
        for (int la:A) {
            System.out.println(la);
        }
    }
}
