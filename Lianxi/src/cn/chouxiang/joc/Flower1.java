package cn.chouxiang.joc;

public class Flower1 extends Flowers{
private String country;
private String city;
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String toString()
{
String infomation=super.toString()+" "+"这种花出自的国家"+country+";"+" "+"出自的城市："+city;
return infomation;
}
}
