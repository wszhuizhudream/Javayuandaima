package cn.qiche.zulin;

public abstract class Vehicle {
private String no;
private String brand;
public Vehicle(){
}
public Vehicle(String no,String brand){
	this.no=no;
	this.brand=brand;
}
public String getNo() {
	return no;
}
public String getBrand() {
	return brand;
}
public abstract int calrent(int days);
}
