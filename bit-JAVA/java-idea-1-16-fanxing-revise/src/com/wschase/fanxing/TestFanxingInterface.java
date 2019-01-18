package com.wschase.fanxing;

/**泛型接口：在接口中定义泛型几句成为泛型接口
 * Author:WSChase
 * Created:2019/1/16
 */
interface Message3<T>{
    public void print(T t);
}



//对于泛型方法的实现：下面两种实现方法的效果是相同的

        //（1）在子类中继续使用泛型方法
//public class TestFanxingInterface<T> implements Message3<T> {
//
////    @Override
////    public void print(T t) {
////        System.out.println(t);
////    }
//    public static void main(String[] args) {
//
//        Message3<String> msg=new TestFanxingInterface<>();
//        msg.print("hello");
//    }
//
//}

    //（2）在子类实现接口的时候明确给出具体类型
    public class TestFanxingInterface implements Message3<String> {

    @Override
    public void print(String t) {//直接指明String类型
        System.out.println(t);
    }

    public static void main(String[] args) {

        Message3<String> msg=new TestFanxingInterface();
        msg.print("hello");
    }

}



