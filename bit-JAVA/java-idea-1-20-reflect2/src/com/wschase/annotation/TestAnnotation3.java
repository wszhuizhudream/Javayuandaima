package com.wschase.annotation;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**自定义一个Annotation
 * Author:WSChase
 * Created:2019/1/20
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    public String name();
    public int age();
}

@Deprecated
@MyAnnotation1(name="xxx",age=20)

class Member3 implements Serializable{}
public class TestAnnotation3 {
    public static void main(String[] args) {

        Annotation[] ant=new Annotation[0];
        ant=Member3.class.getAnnotations();
        for(Annotation a:ant){
            System.out.println(a);
        }
    }
}
