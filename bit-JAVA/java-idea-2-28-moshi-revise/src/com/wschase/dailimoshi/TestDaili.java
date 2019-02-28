package com.wschase.dailimoshi;

/**代理模式：两个类同时实现一个任务，一个是真正的业主，一个是代理人员。
 * 这个任务在接口中放着，它们同时实现这个接口。
 * 练习：
 * 张三要给李四送花，但是它不想自己去送。所以找了一个快递员来帮他送。
 * Author:WSChase
 * Created:2019/2/27
 */
public class TestDaili {
    public static void main(String[] args) {

        SendFlower sd=Factory.getInstance();//这里实现了向上转型
        sd.sendFlower();//调用接口中的这个方法，但是这个方法已经被子类覆写了，所以执行的是覆写以后的方法
                        //但是这个方法是代理员的方法，所以最后是由代理员来实现的这个送花过程。
    }
}
