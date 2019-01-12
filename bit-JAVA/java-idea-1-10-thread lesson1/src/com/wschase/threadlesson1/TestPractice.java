package com.wschase.threadlesson1;

/**
 * Author:WSChase
 * Created:2019/1/10
 */

    /**
     * 编程题
     *  （1）定义一个MulException类继承Exception类，要求两数相乘等于100保错
     *  在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。
     *  （2）定义一个DivException类继承RuntimeException类，
     *  要求两数两除等于2保错。在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果
     */

class MulException extends Exception{
    public MulException(String str){
        super(str);
    }
}

class DivException extends RuntimeException{
    public DivException(String str){
        super(str);
    }
}


public class TestPractice {

    public static void main(String[] args) {
        MulTest();
        DivTest();

    }

    public static void MulTest(){
        try{
            int x=10;
            int y=10;
            if(x*y==100){
                throw new MulException("两数相乘不能等于100");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void DivTest(){
        try{
        int x=4;
        int y=2;
        if(x/y==2){
            throw new DivException("两数相除不能等于2");
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

