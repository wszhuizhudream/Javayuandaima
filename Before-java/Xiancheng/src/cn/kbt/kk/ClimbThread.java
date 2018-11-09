package cn.kbt.kk;

public class ClimbThread extends Thread{
private int time;
public int num = 0;
public ClimbThread(String name,int time,int kilometer){
	super(name);
	this.time=time;
	this.num=kilometer*1000/100;
}
public void run(){
	while (num>0){
	try {
		Thread.sleep(this.time);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	System.out.println(Thread.currentThread().getName()+"爬完100米！");
	num--;	
}
	
	System.out.println(Thread.currentThread().getName()+"到达终点");
}
}