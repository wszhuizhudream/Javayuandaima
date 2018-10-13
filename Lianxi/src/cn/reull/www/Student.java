package cn.reull.www;

public class Student implements Runnable,School 
{
		String schoolname;
		String grade;
		String studentname;
		String studentcode;
		String studentsex;
		String studentcourse;
		String studentavg;
		public Student(String studentname,String studentcode,String studentsex,String studentcourse)
		{
			this.studentname=studentname;
			this.studentcode=studentcode;
			this.studentsex=studentsex;
			this.studentcourse=studentcourse;
			this.toString();
		}
		public void set(String schoolname,String grade)
		{
			this.schoolname=schoolname;
			this.grade=grade;
		}
		public String getschoolname()
		{
			return schoolname;
		}
		public String getgrade()
		{
			return grade;
		}
		public void run()
		{int i=1;
		int avg=85;
		for(;i<13;i++)
		{
			System.out.println("这个学生的平均成绩是："+i+"月"+(avg+i*2));
		}
		}
		public String toString()
		{
			String information="学校名称："+schoolname+";"+" "+"所读年级："+grade+";"+" "+"学生姓名："+studentname+";"+" "+
		"学生学号："+studentcode+";"+" "+"学生性别："+";"+" "+"所读专业："+studentcourse+";"+" "+"学生平均分："+studentavg;
			return information;
			
		}
}
