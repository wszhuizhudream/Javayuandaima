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
//	//�߳�ͬ����������Ҫʵ��ͬ��һ����ͬһ������
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
//		System.out.println(Thread.currentThread().getName()+"������"+num+"��Ʊ��ʣ��"+count+"��Ʊ��");
//		if(Thread.currentThread().getName().equals("������Ʊ")){
//			return false;
//		}
//		return true;
//	} 
public void run(){
	while(true){
		//ͬ�������
		synchronized (this) {
			
		}
	}
}

}
