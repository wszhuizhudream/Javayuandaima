package com.wschase.stack;

import java.util.Stack;

/**栈——先进后出
 * 掌握：
 * 1.入栈:public E push(E item)
 * 2.出栈:public synchronized E pop()
 * 3.观察栈顶元素：public synchronized E peek()
 * Author:WSChase
 * Created:2019/1/15
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.peek());//D
        System.out.println(stack.pop());//D
        System.out.println(stack.peek());//C
        System.out.println(stack.pop());//C
        System.out.println(stack.peek());//B
        System.out.println(stack.pop());//B
        System.out.println(stack.pop());//A
      //  System.out.println(stack.pop());//当没有元素的时候继续出栈观察结果

    }
}
