package cn.rull.www;

public class Pet {
	private String name;
	private int health;
	private int love;
	public Pet(){
		this.health=95;
		System.out.println("ִ�г�����޲ι���");
	}
	public Pet(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public int getLove() {
		return love;
	}
	public void print(){
		System.out.println("������԰ף�\n�ҵ����ֽ�"+this.name+".�ҵĽ���ֵ��"+"�ҵ����ܶ���");
	}
	}
