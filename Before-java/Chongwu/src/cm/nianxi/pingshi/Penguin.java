package cm.nianxi.pingshi;

public class Penguin extends Pet {
private String sex;
public Penguin(String name,String sex){
	super(name);
	this.sex=sex;
}
public String getSex(){
	return sex;
}
public void print(){
	super.print();
	System.out.println("性别是"+this.sex+"。");
}
public void eat() {
	if(getHealth()>=100){
		System.out.println("企鹅"+this.getName() +"吃饱了，不需要喂食了！");
	}else{
		this.setHealth(this.getHealth()+5);
		System.out.println("企鹅"+this.getName() + "吃饱啦！健康值增加3。");
	}
}
}


