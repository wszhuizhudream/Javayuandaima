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
			System.out.println("���ѧ����ƽ���ɼ��ǣ�"+i+"��"+(avg+i*2));
		}
		}
		public String toString()
		{
			String information="ѧУ���ƣ�"+schoolname+";"+" "+"�����꼶��"+grade+";"+" "+"ѧ��������"+studentname+";"+" "+
		"ѧ��ѧ�ţ�"+studentcode+";"+" "+"ѧ���Ա�"+";"+" "+"����רҵ��"+studentcourse+";"+" "+"ѧ��ƽ���֣�"+studentavg;
			return information;
			
		}
}
