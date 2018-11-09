package cn.rull.www;

public class Dog extends Pet{
	private String strain;
	public Dog(String name,String strain){
		super(name);
		this.strain =strain;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("我是一只"+this.getStrain()+"犬.");
	}
	
	
	
}

