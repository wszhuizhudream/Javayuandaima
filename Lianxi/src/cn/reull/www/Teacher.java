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
System.out.println("�����ʦ��нˮ�ǣ�"+i+"��"+(teachersalary+i*300));	
}
}
public String toString()
{
String infomation="ѧУ���ƣ�"+schoolname+";"+" "+"�����꼶:"+grade+";"+" "+
"��ʦ������"+teachername+";"+" "+"��ʦ����"+teachercode+";"+" "+"��ʦ�Ա�"+teachersex+";"+" "
		+"���̿γ̣�"+teachercourse+";"+" "+"��ʦнˮ"+teachersalary;
return infomation;
}
}
