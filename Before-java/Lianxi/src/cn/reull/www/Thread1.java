package cn.reull.www;

public class Thread1 {
public static void main(String[] args) {
	Teacher t=new Teacher("董洁","22334","女","英语");
	t.set("上海师范学院", "三年级");
	Thread th=new Thread(t);
	Student s=new Student("张军","978003","男","计算机");
	s.set("北京大学", "大四");
	Thread th1=new Thread(s);
	th.start();
	th1.start();
}
}
