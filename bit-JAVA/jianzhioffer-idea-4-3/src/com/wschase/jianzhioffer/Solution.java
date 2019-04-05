package com.wschase.jianzhioffer;

/**
 * Author:WSChase
 * Created:2019/4/3
 */

/**
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    public String replaceSpace(StringBuffer str){
        //方法1：
//        String str1=str.toString();
//        String str2=str1.replace(" ","%20");
//        return str2;
        //方法2：
        String str1=str.toString();
        char[] charArray=str1.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for(char c:charArray){
            if(c==' '){
                stringBuilder.append("20%");
            }else {
                stringBuilder.append(c);
            }
        }
        String str2=stringBuilder.toString();
        return str2;
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("We are Happy");
        Solution solution=new Solution();
        String str=solution.replaceSpace(stringBuffer);
        System.out.println(str);

    }
}
