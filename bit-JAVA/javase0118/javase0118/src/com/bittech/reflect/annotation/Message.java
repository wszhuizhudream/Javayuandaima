package com.bittech.reflect.annotation;

import java.util.Arrays;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
@InfoAnnotation(name = "Jack", skill = {"C++", "Java"})
public class Message {
    
    public static void main(String[] args) {
        
        Class messageClass = Message.class;
        InfoAnnotation annotation = (InfoAnnotation) messageClass.getAnnotation(InfoAnnotation.class);
        System.out.println("name=" + annotation.name());
        System.out.println("skill=" + Arrays.toString(annotation.skill()));
        System.out.println("Age=" + annotation.age());
        
    }
}
