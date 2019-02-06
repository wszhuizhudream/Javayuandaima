package com.bittech.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: secondriver
 * Created: 2019/1/18
 * Description: 比特科技，只为更好的你；你只管学习，其它交给我。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoAnnotation {
    
    String name();
    
    String[] skill();
    
    String age() default "23";
}
