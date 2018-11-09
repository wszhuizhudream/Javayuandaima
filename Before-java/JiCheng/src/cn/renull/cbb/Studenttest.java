package cn.renull.cbb;

public class Studenttest {
public static void main(String[] args) {
	Studentclass sc=new Studentclass();
	Studentman sm=new Studentman();
	Studentclass sc1=new Studentman();
	sc.setName("王浩");
	sc.setCode("1");
	sc.setSex("男");
	sc.setAchievement(90.5);
	sm.setName("张杰");
    sm.setCode("2");
    sm.setDuty("班长");
    sm.setSex("男");
    sm.setAchievement(99.0);
    System.out.println(sc.toString());
    System.out.println(sm.toString());
    sc1.setName("赵丽");
	sc1.setCode("3");
	sc1.setSex("女");
	sc1.setAchievement(100);
	System.out.println(sc1.toString());

}
}
