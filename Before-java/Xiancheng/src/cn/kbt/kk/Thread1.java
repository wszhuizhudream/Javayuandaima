package cn.kbt.kk;

public class Thread1 extends Thread {
public void run(){
	for (int i = 0; i < 20; i++) {
		System.out.println(i+"��ã������߳�"+Thread.currentThread().getName());
	}
}
}
