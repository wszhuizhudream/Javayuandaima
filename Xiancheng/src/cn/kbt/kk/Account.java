package cn.kbt.kk;

public class Account {
public int banlance=100;
public int getBanlance(){
	return banlance;
}
public void Withdraw(int num){
	banlance=banlance-num;
}
}
