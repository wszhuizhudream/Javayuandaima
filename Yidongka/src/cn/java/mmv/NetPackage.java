package cn.java.mmv;

public class NetPackage extends ServicePackage implements NetService {
private int flow;

@Override
public int netService(int flow, MobileCard card) throws Exception {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void showInfo() {
	// TODO Auto-generated method stub
	System.out.println("�����ײͣ�����������"+flow/1024+"GB/��,���ʷ���");
}
public void netPlay2(int flow,MobileCard card)throws Exception{
	int reminFlow = this.flow - card.getRealFlow();
	if (this.flow<=reminFlow){
		card.setRealFlow(card.getRealFlow()+flow);
	}else{
		double consumeMoney = 0.1*(flow-reminFlow);
		if (card.getMoney()>=consumeMoney){
			card.setRealFlow(card.getRealFlow()+flow);
			card.setRealMoney(card.getRealMoney()-consumeMoney);
			card.setConsumeAmount(card.getConsumeAmount()+consumeAmount);
			
		}
	}
}
}
