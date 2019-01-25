package com.wschase.kebiancanshu;

/**函数的参数有多个的时候：
 * 我们的可变参数在函数的参数中有且只能有一个，并且放在参数的最后
 * Author:WSChase
 * Created:2019/1/23
 */
public class Test2 {

    public static int add(String msg,int ... data){
        int result=0;
        for(int i=0;i<data.length;i++){
            result+=data[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add("hello"));
        System.out.println(add("hello",1,2,3,4));
        System.out.println(add("world",new int[]{1,4,5,6}));
    }
}
