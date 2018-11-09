package cn.jbit.exception;

public class Person {
private String name = "";
private int age = 0;
private String sex = "男";

public void setSex(String sex)throws Exception{
	if ("男".equals(sex)||"女".equals(sex))
		this.sex=sex;
	else{
		throw new Exception("性别必须是男或者女！");
	}
}
public void setAge(int age)throws Exception{
	if (age>=1 && age<=100)
		this.age=age;
else{
	throw new Exception("年龄");
}
}
public void  print(){
	System.out.println(this.name+"("+this.sex+","+this.age+"岁)");
}
}
