package cn.jbit.exception;

public class Person {
private String name = "";
private int age = 0;
private String sex = "��";

public void setSex(String sex)throws Exception{
	if ("��".equals(sex)||"Ů".equals(sex))
		this.sex=sex;
	else{
		throw new Exception("�Ա�������л���Ů��");
	}
}
public void setAge(int age)throws Exception{
	if (age>=1 && age<=100)
		this.age=age;
else{
	throw new Exception("����");
}
}
public void  print(){
	System.out.println(this.name+"("+this.sex+","+this.age+"��)");
}
}
