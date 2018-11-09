package cm.nianxi.pingshi;

public class Cat extends Pet{
private String strain;
public Cat(String name,String strain){
	super(name);
	this.strain=strain;
}
public String getStrain() {
	return strain;
}
public void setStrain(String strain) {
	this.strain = strain;
}
public void eat(){
	System.out.println("");
}
}
