package cn.kbt.kk;

public class Threadpriority {
public static void main(String[] args) {
	Thread mainThread=Thread.currentThread();
	Thread myThread=new Thread(new MyThread5());
	System.out.println("------��ʾĬ���߳����ȼ�------");
	System.out.println("���߳�����"+mainThread.currentThread().getName()+"���ȼ���"+mainThread.getPriority());
	System.out.println("���߳�����"+myThread.currentThread()+"���ȼ���"+myThread.getPriority());
	System.out.println("------�޸�Ĭ�����ȼ���------");
	mainThread.setPriority(Thread.MAX_PRIORITY);
	myThread.setPriority(Thread.MIN_PRIORITY);
	System.out.println("���߳�����"+mainThread.currentThread().getName()+"���ȼ���"+mainThread.getPriority());
	System.out.println("���߳�����"+myThread.currentThread()+"���ȼ���"+myThread.getPriority());
}
}
class MyThread5 implements Runnable{
	public void run(){
		
	}
}
