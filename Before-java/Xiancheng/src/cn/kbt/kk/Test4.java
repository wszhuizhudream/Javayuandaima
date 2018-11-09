package cn.kbt.kk;

public class Test4 {
public static void main(String[] args) {
	System.out.println("-----线程强制执行-----");
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
		System.out.println(Thread.currentThread().getName()+"运行："+i);
	}
}
}
