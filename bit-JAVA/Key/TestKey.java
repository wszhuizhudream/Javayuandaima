class KeyWord{//私有类
	private String name;
	private int age;
	
	public KeyWord(String name,int age){
		name=name;
		age=age;
	}
	public String getKeyWoInfo(){
		return "姓名"+name+",年龄"+age;
	}
}
	public class TestKey{//共有类
	public static void main(String[] args){
		KeyWord per = new KeyWord("张三",20);
		System.out.println(per.getKeyWoInfo());
	}
}