package cn.qiche.zulin;

public final class Car extends Vehicle{
private String type;
public Car(){
}
public Car(String no,String brand,String type){
	super(no,brand);
	this.type=type;
}
public int calrent(int days){
	if("1".equals(type)){
		return days*600;
	}
	if("2".equals(type)){
		return days*500;
	}
	else{
		return days*300;
	}
}
}
