package cn.java.mmv;

public class SuperPackage extends ServicePackage implements CallService,SendService,NetService {
private int talkTime;
private int smsCount;
private int flow;
	public SuperPackage(int talkTime, int smsCount, int flow) {
	super();
	this.talkTime = 200;
	this.smsCount = 50;
	this.flow = 1*1024;
	this.price=78.0;
}

	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("�����ײͣ�ͨ��ʱ��Ϊ"+this.talkTime+"��=����/��,��������Ϊ��");
	}
	public int netPlay(int flow,MobileCard card)throws Exception{
		int temp = flow;
		for(int i=0;i<flow;i++){
			if(this.flow-card.getRealFlow()>=1){
				card.setRealFlow(card.getRealFlow()+1);
			}else if(card.getMoney()>=0.1){
				card.setRealFlow(card.getRealFlow()+1);
				card.getMoney(common.sub(card.getMoney(),0.1);
				card.setConsumeAmount(card.getConsumeAmount+0.1);
			}else{
				temp=i;
				throws new Exception("������ʹ������"+i+"MB,�������㣬���ֵ����ʹ��");
			}	
		}
		return temp;
	}

}
