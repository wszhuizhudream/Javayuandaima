package com.wschase.annotation;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**在方法上使用Annotation
 * Author:WSChase
 * Created:2019/1/20
 */

@SuppressWarnings("serial")
@Deprecated

class Member implements Serializable{
    @Deprecated
    @Override
    public String toString(){
        return super.toString();
    }
}
public class TestAnnotation2 {
    public static void main(String[] args) {
        Annotation[] ant=new Annotation[0];
        try{
            ant=Member.class.getMethod("toString").getAnnotations();

        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        for(Annotation a:ant){
            System.out.println(a);
        }
    }
}
