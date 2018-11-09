package cn.kbt.kk;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 15; i++) {
			System.out.println(i+Thread.currentThread().getName());
		}
		
	}

}
