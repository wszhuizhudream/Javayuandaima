package cn.renull.vo;

public class Student extends Person{

	@Override
	public Student clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("销毁对象");
	}


//	@Override
//	public String eat(String a, String b) {
//	
//		return super.eat(a, b);
//	}
//	
//	
//	private int calc(int a){
//		return a*10;
//	}

//	public String eat(String c,String d){
//		return c+"你好"+d;
//	}
	
	
	
	
}
