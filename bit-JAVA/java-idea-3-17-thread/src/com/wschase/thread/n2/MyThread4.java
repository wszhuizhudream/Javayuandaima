package com.wschase.thread.n2;

/**通过实现Runnable接口实现买票——数据共享
 * Author:WSChase
 * Created:2019/3/17
 */
class Ticket1 implements Runnable{

    private int ticket=10;

    @Override
    public void run() {
    while(this.ticket>0){
        System.out.println("剩余票数："+this.ticket--);
    }
    }
}
public class MyThread4 {
    public static void main(String[] args) {
        Ticket1 ticket1=new Ticket1();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
        new Thread(ticket1).start();
    }
}
