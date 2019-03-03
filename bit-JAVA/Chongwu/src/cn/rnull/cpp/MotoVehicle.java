package cn.rnull.cpp;

public abstract class MotoVehicle {
private String no;
private String Brand;
public MotoVehicle(){
}
public MotoVehicle(String no,String Brand){
	this.no=no;
	this.Brand=Brand;
}
public String getNo() {
	return no;
}
public String getBrand() {
	return Brand;
}
	public abstract int CalRent(int days);
}
