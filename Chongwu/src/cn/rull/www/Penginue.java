package cn.rull.www;

public class Penginue extends Pet {
	private String sex;
	public Penginue(String name,String sex){
		super(name);
		this.sex =sex;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public void print(){
		super.print();
		System.out.println("我的性别是"+this.getSex()+".");
	}
}
