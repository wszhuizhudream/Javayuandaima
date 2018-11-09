package cn.kbt.kk;

public class Threadpriority {
public static void main(String[] args) {
	Thread mainThread=Thread.currentThread();
	Thread myThread=new Thread(new MyThread5());
	System.out.println("------显示默认线程优先级------");
	System.out.println("主线程名："+mainThread.currentThread().getName()+"优先级："+mainThread.getPriority());
	System.out.println("子线程名："+myThread.currentThread()+"优先级："+myThread.getPriority());
	System.out.println("------修改默认优先级后------");
	mainThread.setPriority(Thread.MAX_PRIORITY);
	myThread.setPriority(Thread.MIN_PRIORITY);
	System.out.println("主线程名："+mainThread.currentThread().getName()+"优先级："+mainThread.getPriority());
	System.out.println("子线程名："+myThread.currentThread()+"优先级："+myThread.getPriority());
}
}
class MyThread5 implements Runnable{
	public void run(){
		
	}
}
