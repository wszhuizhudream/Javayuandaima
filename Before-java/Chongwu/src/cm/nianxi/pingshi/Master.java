package cm.nianxi.pingshi;

public class Master {
private String name="";
private int money=0;
public Master(String name,int money){
	this.name=name;
	this.money=money;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public Pet getPet(int typeId){
	Pet pet=null;
	if(typeId==1){
		pet= new Cat("Å·Å·", "Ñ©ÄÈÈğ");
	}else if(typeId==2){
		pet  = new Penguin("éªéª", "QÃÃ");
	}
	return pet;
}
public void feed(Pet pet){
 pet.eat();
}
}
