package cn.java.mmv;

public class TalkPackage extends ServicePackage implements CallService,
	SendService{
		private int talkTavime;
		private int smsCount;
		public int getTalkTavime() {
			return talkTavime;
		}
		public void setTalkTavime(int talkTavime) {
			this.talkTavime = talkTavime;
		}
		public int getSmsCount() {
			return smsCount;
		}
		public void setSmsCount(int smsCount) {
			this.smsCount = smsCount;
		}
		public TalkPackage(int talkTime,int smsCount){
		super();
		this.talkTime=talkTime;
		this.smsCount=smsCount;
		} 
		@Override
		public int netPlay(int flow, MobileCard card) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int call(int minCount, MobileCard card) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public void showInfo() {
			// TODO Auto-generated method stub
			
		}
		
	}

