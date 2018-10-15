package cn.kbt.kk;

public class Test3 {
public static void main(String[] args) {
	Thread t1=new Thread(new MyThread1(),"线程A");
	Thread t2=new Thread(new MyThread1(),"线程B");
	t1.setPriority(Thread.MAX_PRIORITY);
	t2.setPriority(Thread.MIN_PRIORITY);
	t1.start();
	t2.start();
}
}
