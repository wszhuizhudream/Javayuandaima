package com.wschase.replace2;

/**真正实现功能的类
 * Author:WSChase
 * Created:2019/3/26
 */
public class RealSubject implements ISubject{
    @Override
    public void eat(String msg,int num) {
        System.out.println("吃:"+msg+"数量："+num);
    }
}
