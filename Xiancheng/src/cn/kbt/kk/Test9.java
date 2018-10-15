package cn.kbt.kk;

public class Test9 {
public static void main(String[] args) {
	MyThread8 thread1=new MyThread8();
	thread1.start();
}
}
class MyThread8 extends Thread{
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
