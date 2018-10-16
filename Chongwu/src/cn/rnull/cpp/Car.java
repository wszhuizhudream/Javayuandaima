package cn.rnull.cpp;

public final class Car extends MotoVehicle {
	private String type;
	public Car(){
	} 
	public Car(String no,String Brand,String type){
		super(no,Brand);
		this.type=type;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	public int CalRent(int days){
		if("1".equals(type)){
			return(days*600);
		}
		if("2".equals(type)){
			return(days*500);
		}else{
			return(days*300);
		}
	}
	}
