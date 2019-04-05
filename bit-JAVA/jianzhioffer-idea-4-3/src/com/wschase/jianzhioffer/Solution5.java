package com.wschase.jianzhioffer;

/**
 * Author:WSChase
 * Created:2019/4/3
 */

/**
 * 1.一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 其实质就是斐波那契数列
 */

/**
 * 2.一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 分析：
 * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
 * 跳1级:有1种跳法
 * 跳2级：有2种跳法
 * 跳3级：有4种跳法
 * 跳n级：有2^(n-1)种跳法
 * 即该题就是实现2^(n-1)
 */
public class Solution5 {
//    public static int Jump1(int target){
//        if(target<0){
//            return 0;
//        }else if(target==1){
//            return 1;
//        }else if(target==2){
//            return 2;
//        }
//        else {
//            int one=1;
//            int two=2;
//            int result=0;
//            for(int i=2;i<target;i++){
//                result = one+two;
//                one=two;
//                two=result;
//            }
//            return result;
//        }
//    }
    public int JumpFloor(int target) {

        if(target==0){
            return 0;
        }
        int num=1;
        return num<<(target-1);

    }
}
