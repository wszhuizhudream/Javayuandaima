package com.wschase.tongpeifu;


/**通配符的介绍
 * Author:WSChase
 * Created:2018/12/12
 */
class Message1<T> {
    private T messgae;

    public T getMessage() {
        return messgae;
    }

    public void setMessage(T messgae) {
        this.messgae = messgae;
    }
}
public class TestTongpeifu {
    //1.通配符的使用
    public static void main(String[] args) {
        Message<Integer> message=new Message();//在这可以接收整型的数据
        message.setMessage(55);
        Message<String> message1=new Message<>();//也可以接收字符串
        message1.setMessage("你好");
        Message<Double> message2=new Message<>();//也可以接收双精度的小数
        message2.setMessage(12.35);
        fun(message);
        fun(message1);
        fun(message2);
    }
    public static void fun(Message<?> temp){//这个地方就使用了通配符
        //但是由于通配符不是具体的类型，所以我们不能修改值-> temp.setMessage(100);//error
        System.out.println(temp.getMessage());
        //当我们使用了通配符以后就可以接收任意类型的值了，可以体统给用户的方法是它们可以任意的修改
    }
}
