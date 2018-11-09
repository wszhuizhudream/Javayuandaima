package cn.jbit.handset.impl;

import cn.jbit.handset.factory.Handset;
import cn.jbit.handset.factory.PlayWiring;

public class CommonHandset extends Handset implements PlayWiring {
public CommonHandset(){
}
public CommonHandset(String brand,String type){
	super(brand,type);
}
public void play(String content) {
	System.out.println("开始播放音乐《"+content+"》......");
}
public void sendInfo() {
	System.out.println("发送文字信息......");
}
public void call() {
	System.out.println("开始语音通话.....");
}
}

