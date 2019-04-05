package com.wschase.jianzhioffer;

/**
 * Author:WSChase
 * Created:2019/4/3
 */

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Solution8 {
    public double Power(double base, int exponent) {

        //首先经过分析，求解一个数的n次方有三种情况：exponent>0、exponent<0、exponent=0
        double result=1;
        if(exponent>0){
            for(int i=1;i<=exponent;i++){
                result=result*base;
                if(result>1.7976931348623157E308){
                    System.out.println("已经超出了double类型的范围");
                    return -1;
                }
            }
            return result;
        }
        if(exponent<0){
            exponent=-exponent;
            for(int i=1;i<=exponent;i++){
                result=result*base;
                if(result>1.7976931348623157E308){
                    System.out.println("已经超出了double类型的范围");
                    return -1;
            }
        }
        result=1.0/result;
            return result;
    }else {
            return 1;
        }
    }


}
