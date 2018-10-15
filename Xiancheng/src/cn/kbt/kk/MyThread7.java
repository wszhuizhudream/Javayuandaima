package cn.kbt.kk;

public class MyThread7 extends Thread {
		private String name;
		public MyThread7(String name1){
			this.name=name1;
		}
	public void run(){
		synchronized ("") {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
			 }
				System.out.println(this.name+":" + i);
			}
		}
	}
	}
