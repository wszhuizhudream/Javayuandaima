package cn.renull.cbb;

public class Studentman extends Studentclass{
private String duty;

public String getDuty() {
	return duty;
}

public void setDuty(String duty) {
	this.duty = duty;
}
public String toString()//ͨ��toString���������ö������ַ�����ʽ���
{
	String infor="ѧ��������"+name+" "+"ѧ�ţ�"+" "+code+" "+"�Ա�"+sex+" "+"ְ��"+duty+" "+"�ɼ���"+achievement;
    return infor;
}
}
