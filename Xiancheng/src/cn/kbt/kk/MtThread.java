package cn.kbt.kk;

public class MtThread extends Thread{
	private String name;
	public MtThread(String name){
		this.name=name;
	}
public void run(){
	synchronized ("") {
		for (int i = 10; i < 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(this.name+":"+i);
		}
	}
}
}
