package cn.kbt.kk;

public class Test6 {
public static void main(String[] args) {
	Thread t = new Thread(new Thread4());
	t.setPriority(Thread.MAX_PRIORITY);
	t.start();
	for (int i = 0; i < 20; i++) {
		System.out.println("ÆÕÍ¨ºÅ£º"+(i+1)+"ºÅ²¡ÈË¿´²¡");
		try {
			Thread.sleep(500);
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		if(i==9){
			try {
				t.join();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
}
