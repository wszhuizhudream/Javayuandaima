package cn.renull.cbb;

public class Studentclass {
String name;
String code;
String sex;
double achievement;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public double getAchievement() {
	return achievement;
}
public void setAchievement(double achievement) {
	this.achievement = achievement;
}
public String toString()//通过toString方法可以让对象以字符串形式输出
{
	String infor="学生姓名："+name+" "+"学号："+" "+code+" "+"性别："+sex+" "+"成绩："+achievement;
    return infor;
}
}
