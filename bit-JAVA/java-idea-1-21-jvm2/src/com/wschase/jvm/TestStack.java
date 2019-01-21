package com.wschase.jvm;

/**栈溢出
 * Author:WSChase
 * Created:2019/1/21
 */
public class TestStack {

    public int stackDepth=1;

    //1.典型的递归调用
    //2.递归无出口
    public void setStack(){
        this.stackDepth++;
        this.setStack();
    }

    public static void main(String[] args) {
        TestStack testStack=new TestStack();
        try{
            testStack.setStack();
        }catch (Throwable e){
            System.out.println("异常信息："+e.getMessage());
        }
        System.out.println("调用深度："+testStack.stackDepth);
    }
}
