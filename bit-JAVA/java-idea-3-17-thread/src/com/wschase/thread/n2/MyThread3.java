package com.wschase.thread.n2;

/**继承Thread实现卖票功能
 * Author:WSChase
 * Created:2019/3/17
 */
class Ticket extends Thread{
    private int ticket=10;

    @Override
    public void run() {
        while (this.ticket>0){
            System.out.println("剩余票数："+this.ticket--);
        }
    }
}

public class MyThread3 {
    public static void main(String[] args) {
        //我们想要实现的是它们共同卖的是同一张票，但是现在它们各自卖各自的票
        //并没有实现数据共享。
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
    }
}
