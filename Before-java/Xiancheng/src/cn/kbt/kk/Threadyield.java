package cn.kbt.kk;

public class Threadyield {
public static void main(String[] args) {
	System.out.println("-----线程的礼让-----");
	Thread m=new Thread();
	Thread t1=new Thread(m,"线程A");
	Thread t2=new Thread(m,"线程B");
	t1.start();
	t2.start();
}
}
