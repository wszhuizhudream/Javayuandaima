package cn.kbt.kk;

public class Test1 {
public static void main(String[] args) {
	MyRunnable s1=new MyRunnable();
	MyRunnable s2=new MyRunnable();
	Thread t1=new Thread(s1);
	Thread t2=new Thread(s2);
	t1.start();
	t2.start();
}
}
