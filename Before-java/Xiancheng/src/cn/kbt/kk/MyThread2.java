package cn.kbt.kk;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"运行："+i);
			if(1==3){
				System.out.println("线程礼让");
				Thread.yield();
			}
		}
	}

}
