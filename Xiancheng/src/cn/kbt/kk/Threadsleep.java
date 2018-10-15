package cn.kbt.kk;

public class Threadsleep {
public static void main(String[] args) {
	System.out.println("Wait");
	Wait.bySec(5);
	System.out.println("start");
}
static class Wait{
	public static void bySec(long s){
		for (int i = 0; i < s; i++) {
        System.out.println(i+1+"Ãë");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
	}
}

}
