package com.wschase.boot.config;

import com.wschase.boot.component.ExampleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Properties;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
@Configuration
public class AppConfiguration {
    @Bean(value="hello")
    public String helloString(){
        return "hello";
    }

    @Bean(value="welcome")
    public String welcomeString(){
     return "welcome";
    }

    @Bean(value="properties")
    public Properties propertiesString(){
        return new Properties();
    }


    //这个Bean是通过我们自己定义的方式来实现的
    @Bean(initMethod="init",destroyMethod="destroy")
    @Scope(scopeName="prototype")//这个表示下面的这个是单例
    public ExampleBean exampleBean(){
       ExampleBean exampleBean= new ExampleBean();
       exampleBean.setName("Jack");
       return exampleBean;
    }
}
