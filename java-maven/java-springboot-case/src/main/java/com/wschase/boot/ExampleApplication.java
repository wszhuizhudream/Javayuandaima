package com.wschase.boot;

import com.wschase.boot.component.ExampleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Author:WSChase
 * Created:2019/4/28
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:application-bean.xml"})
public class ExampleApplication {
    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(ExampleApplication.class,args);

        ExampleBean exampleBean1=context.getBean(ExampleBean.class);
        ExampleBean exampleBean2=context.getBean(ExampleBean.class);
        //它们两个是不等的
        System.out.println(exampleBean1==exampleBean2);


    }
}
