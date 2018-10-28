package cn.java.mmv;

public class MobileCard {
private String cardNumber;
private String userName;
private String passWord;
private ServicePackage serPackage;
private String money;
private String realTalkTime;
private String realSMSCount;
private String realFlow;

public MobileCard(String cardNumber, String userName, String passWord,
		ServicePackage serPackage, String money, String realTalkTime,
		String realSMSCount, String realFlow) {
	super();
	this.cardNumber = cardNumber;
	this.userName = userName;
	this.passWord = passWord;
	this.serPackage = serPackage;
	this.money = money;
	this.realTalkTime = realTalkTime;
	this.realSMSCount = realSMSCount;
	this.realFlow = realFlow;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public ServicePackage getSerPackage() {
	return serPackage;
}
public void setSerPackage(ServicePackage serPackage) {
	this.serPackage = serPackage;
}
public String getMoney() {
	return money;
}
public void setMoney(String money) {
	this.money = money;
}
public String getRealTalkTime() {
	return realTalkTime;
}
public void setRealTalkTime(String realTalkTime) {
	this.realTalkTime = realTalkTime;
}
public String getRealSMSCount() {
	return realSMSCount;
}
public void setRealSMSCount(String realSMSCount) {
	this.realSMSCount = realSMSCount;
}
public String getRealFlow() {
	return realFlow;
}
public void setRealFlow(String realFlow) {
	this.realFlow = realFlow;
}

}
