package cn.kbt.kk;

public class Test4 {
public static void main(String[] args) {
	System.out.println("-----�߳�ǿ��ִ��-----");
	Thread m=new Thread(new Thread3());
	m.start();
	for (int i = 0; i <20; i++) {
		if(i==5){
			try {
				m.join();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"���У�"+i);
	}
}
}
