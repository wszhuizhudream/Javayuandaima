package cn.kbt.kk;

public class Test10 {
public static void main(String[] args) {
	Thread thread2 = new Thread(new MyThread10());
	thread2.start();
}
}
class MyThread10 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
}
