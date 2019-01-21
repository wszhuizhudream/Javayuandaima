package com.wschase.annotation;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**取得定义在类上的Annotation
 * Author:WSChase
 * Created:2019/1/20
 */
@SuppressWarnings("serial")
@Deprecated

class Member1 implements Serializable{}

public class TestAnnotation1 {

    public static void main(String[] args) {
        Annotation[] ant=Member1.class.getAnnotations();
        for(Annotation a:ant){
            System.out.println(a);
        }
    }
}
