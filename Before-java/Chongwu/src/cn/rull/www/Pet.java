package cn.rull.www;

public class Pet {
	private String name;
	private int health;
	private int love;
	public Pet(){
		this.health=95;
		System.out.println("执行宠物的无参构造");
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
		System.out.println("宠物的自白：\n我的名字叫"+this.name+".我的健康值是"+"我的亲密度是");
	}
	}
