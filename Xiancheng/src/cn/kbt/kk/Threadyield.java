package cn.kbt.kk;

public class Threadyield {
public static void main(String[] args) {
	System.out.println("-----�̵߳�����-----");
	Thread m=new Thread();
	Thread t1=new Thread(m,"�߳�A");
	Thread t2=new Thread(m,"�߳�B");
	t1.start();
	t2.start();
}
}
