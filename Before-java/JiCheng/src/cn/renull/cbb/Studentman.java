package cn.renull.cbb;

public class Studentman extends Studentclass{
private String duty;

public String getDuty() {
	return duty;
}

public void setDuty(String duty) {
	this.duty = duty;
}
public String toString()//通过toString方法可以让对象以字符串形式输出
{
	String infor="学生姓名："+name+" "+"学号："+" "+code+" "+"性别："+sex+" "+"职务"+duty+" "+"成绩："+achievement;
    return infor;
}
}
