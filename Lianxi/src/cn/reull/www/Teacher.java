package cn.reull.www;

public class Teacher implements Runnable,School
{
String schoolname;
String grade;
String teachername;
String teachercode;
String teachersex;
String teachercourse;
String teachersalary;
public Teacher(String teachername,String teachercode,String teachersex,String teachercourse)
{
	this.teachername=teachername;
	this.teachercode=teachercode;
	this.teachersex=teachersex;
	this.teachercourse=teachercourse;
    this.toString();
}
public void set(String schoolname,String grade)
{
this.schoolname=schoolname;
this.grade=grade;
}
public String getgrade()
{
return grade;	
}
public String getschoolname()
{
return schoolname;	
}
public void run()
{
int i=1;
int teachersalary=2000;
for(;i<13;i++)
{
System.out.println("这个老师的薪水是："+i+"月"+(teachersalary+i*300));	
}
}
public String toString()
{
String infomation="学校名称："+schoolname+";"+" "+"所在年级:"+grade+";"+" "+
"教师姓名："+teachername+";"+" "+"教师工号"+teachercode+";"+" "+"教师性别"+teachersex+";"+" "
		+"所教课程："+teachercourse+";"+" "+"教师薪水"+teachersalary;
return infomation;
}
}
