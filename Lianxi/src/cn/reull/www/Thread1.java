package cn.reull.www;

public class Thread1 {
public static void main(String[] args) {
	Teacher t=new Teacher("����","22334","Ů","Ӣ��");
	t.set("�Ϻ�ʦ��ѧԺ", "���꼶");
	Thread th=new Thread(t);
	Student s=new Student("�ž�","978003","��","�����");
	s.set("������ѧ", "����");
	Thread th1=new Thread(s);
	th.start();
	th1.start();
}
}
