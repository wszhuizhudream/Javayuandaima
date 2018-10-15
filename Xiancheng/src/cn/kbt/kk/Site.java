package cn.kbt.kk;

public class Site implements Runnable {
private int count=10;
private int num=0;
//private boolean flag = false; 
//	@Override
//	public void run() {
//		while(true){
//			if(!sale()){
//				break;
//			}
//		}
//		// TODO Auto-generated method stub
//	}
//	//线程同步方法：想要实现同步一定是同一个对象
//	public synchronized boolean sale(){
//		if(count<=0){
//			return false;
//		}
//		num++;
//		count--;
//		try {
//			Thread.sleep(500);
//		} catch (Exception e) {
//			// TODO: handle exception
//		e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName()+"抢到第"+num+"张票，剩余"+count+"张票！");
//		if(Thread.currentThread().getName().equals("好友抢票")){
//			return false;
//		}
//		return true;
//	} 
public void run(){
	while(true){
		//同步代码块
		synchronized (this) {
			
		}
	}
}

}
