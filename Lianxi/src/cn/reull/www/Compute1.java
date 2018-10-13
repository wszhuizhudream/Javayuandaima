package cn.reull.www;

public class Compute1 implements Runnable {
public void run()
{
	for (int i=0;i<10;i++)
System.out.println("这个数字是："+i);	
}
}
