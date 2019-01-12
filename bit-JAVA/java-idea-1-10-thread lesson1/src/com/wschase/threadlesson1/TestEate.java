package com.wschase.threadlesson1;

/**
 * Author:WSChase
 * Created:2019/1/10
 */

/**
 * 题目：候子吃桃
 * 候子一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
 * 以后每天都吃了前一天剩下的一半零一个。
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天一共摘下了多少个桃子
 */
public class TestEate {
    public static void main(String[] args) {

        //循环
            int result=1;
        for(int i=1;i<10;i++){
            result=(result+1)*2;
        }
        System.out.println("这个是循环方法的结果："+result);
        System.out.println("这个是递归方法的结果："+getTotal(1));
    }

    //递归
    public static int getTotal(int day){
        if(day==10){
            return 1;
        }else {
            return (getTotal(day+1)+1)*2;
        }
    }
}
