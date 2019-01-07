package com.wschase.hashmap;

import java.util.Stack;

/**
 * Author:WSChase
 * Created:2019/1/7
 */
//一、栈--》先进后出
    //在生活中有很多这样的例子，就是先进后厨，这些的原理都是堆栈的原理
    //比如：浏览器的关闭、编辑器的撤销、座位等等
    //在我们的java中提供了一个stack类，这个类是vector的子类
    //其中：入栈是push      出栈用pop
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        System.out.println("当前栈是否为空："+stack.isEmpty());
        //入栈
        stack.push("java");
        stack.push("C++");
        stack.push("PHP");
        System.out.println("当前栈是否为空："+stack.isEmpty());
        System.out.println("当前栈的元素个数："+stack.size());
        //观察栈顶——>这个peek()就是取得栈顶元素的函数
        System.out.println("栈顶是否是PHP："+"PHP".equals(stack.peek()));

        //出栈
        System.out.println(stack.pop());//PHP——>出栈的元素
        System.out.println(stack.pop());//C++
        System.out.println(stack.pop());//java
        System.out.println(stack.pop());//?（此时栈为空）

        //重要：如果我们的栈空会抛异常,所以我们出栈的时候需要判断一下我们的栈是否为空
        while ((!stack.isEmpty())){
            System.out.println(stack.pop());
        }
    }
}

