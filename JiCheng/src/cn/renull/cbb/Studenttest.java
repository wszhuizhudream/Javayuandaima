package cn.renull.cbb;

public class Studenttest {
public static void main(String[] args) {
	Studentclass sc=new Studentclass();
	Studentman sm=new Studentman();
	Studentclass sc1=new Studentman();
	sc.setName("����");
	sc.setCode("1");
	sc.setSex("��");
	sc.setAchievement(90.5);
	sm.setName("�Ž�");
    sm.setCode("2");
    sm.setDuty("�೤");
    sm.setSex("��");
    sm.setAchievement(99.0);
    System.out.println(sc.toString());
    System.out.println(sm.toString());
    sc1.setName("����");
	sc1.setCode("3");
	sc1.setSex("Ů");
	sc1.setAchievement(100);
	System.out.println(sc1.toString());

}
}
