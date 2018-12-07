package com.bittech.senum;

/**
 * Author:WSChase
 * Created:2018/11/28
 */
enum Color {
    RED,GREEN,BLUE
}
public class Enums{
    public static void main(String[] args) {
        for(Color temp:Color.values()){
            System.out.println(temp.ordinal()+"="+temp.name());
        }
    }
}
