package com.wschase.jianzhioffer;

/**
 * Author:WSChase
 * Created:2019/4/3
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 */
public class Sulotion7 {
    public int NumberOf1(int n) {

        //首先需要将这个数转化为二进制数，然后将这个二进制数转化为数组存进数组里面
        //再通过遍历得到结果。
        int num=0;
        /**
         * toBinaryString(n)
         *传入的是十进制的数，通过方法返回一个二进制的数
         */
        String b=Integer.toBinaryString(n);
        char[] c=b.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='1'){
               num++;
            }
        }
        return num;
    }
}
