package cn.chouxiang.joc;

public class Flowers implements Flower 
{
private String color1;
private String name;
public void setcolor(String color1)
{this.color1=color1;}
public void setname(String name)
{this.name=name;}
public String getcolor()
{return color1;}
public String getname()
{return name;}
public String toString()
{
	String infomation="花的名称是："+name+";"+" "+"花的颜色是："+color1;
	return infomation;
}
}
