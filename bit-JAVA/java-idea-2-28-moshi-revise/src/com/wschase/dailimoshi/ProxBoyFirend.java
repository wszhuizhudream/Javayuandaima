package com.wschase.dailimoshi;

/**代理员
 * Author:WSChase
 * Created:2019/2/27
 */
public class ProxBoyFirend implements SendFlower {
    //对于我们的代理人员要去送花需要考虑到一些细节的东西
    //（1）去之前打电话确定是否有人在
    //（2）如果有人在就送花
    //（3）送完花以后签收
        private SendFlower sendPeople;//真正的业主：声明对象

    public ProxBoyFirend(SendFlower sendPeople){
        this.sendPeople=sendPeople;
    }

    public void tel(){
        System.out.println("打电话确认是否有人在");
    }

    public void write(){
        System.out.println("收到花以后签收");
    }

    @Override
    public void sendFlower() {
    this.tel();
    this.sendPeople.sendFlower();//在代理模式下这个是最重要的一个地方，它通过真正的业主来调用它要实现的功能
    this.write();
    }
}


class Factory{
    public static  SendFlower getInstance(){
        return new ProxBoyFirend(new BoyFirend());//实现了向上转型
    }
}