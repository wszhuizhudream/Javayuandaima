package com.books;

public class Book {
int id;
String name;
int state;
public String toString(){
	String stateName="";
	if (this.state==1){
		stateName="�ɽ���";
	}else{
		stateName="���ɽ���";
	}
	return this.id+"\t\t"+this.name+"\t\t"+stateName;
}
}

