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
	System.out.println("�Ա���"+this.sex+"��");
}
public void eat() {
	if(getHealth()>=100){
		System.out.println("���"+this.getName() +"�Ա��ˣ�����Ҫιʳ�ˣ�");
	}else{
		this.setHealth(this.getHealth()+5);
		System.out.println("���"+this.getName() + "�Ա���������ֵ����3��");
	}
}
}


