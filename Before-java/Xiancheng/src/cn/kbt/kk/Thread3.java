package cn.kbt.kk;

public class Thread3 implements Runnable {
	public void run(){
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"ÔËÐÐ"+i);
		}
	}
}
