package cn.rnull.cpp;

public final class Bus extends MotoVehicle {
	private int seatCount;
	public Bus(){
	} 
	public Bus(String no,String Brand,int seatCount){
		super(no,Brand);
		this.seatCount = seatCount;
	}
	public int getSeatCount(){
		return seatCount;
	}
	public void setSeatCount(int seatCount){
		this.seatCount=seatCount;
	}
	public int CalRent(int days){
		if (seatCount<=16){
			return days*800;
		}else{
			return days*1500;
		}
	}

}
