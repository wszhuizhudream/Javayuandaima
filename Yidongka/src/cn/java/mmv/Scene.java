package cn.java.mmv;

public class Scene {
private String type;
private int data;
private String description;
public Scene(){}
public Scene(String type,int data,String description){
	this.type=type;
	this.data =data;
	this.description=description;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
