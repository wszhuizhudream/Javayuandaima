package com.wschase.boot.control;

import com.wschase.boot.component.ExampleBean;
import com.wschase.boot.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:WSChase
 * Created:2019/4/28
 */
@RestController
@RequestMapping
public class IndexController {
//    @RequestMapping(value = "")
//    public String index() {
//        return "Hello Spring Boot World ";
//}

    @Autowired
    private ExampleBean exampleBean;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/appconfig",method = {RequestMethod.GET})
    public String appconfig(){
        return appConfig.toString();
    }


    //可以同时取到环境变量、配置信息等
    @RequestMapping(value = "/environment",method = {RequestMethod.GET})
    public Map<String,Object> environment(){
        Map<String,Object> map=new HashMap<>();
        map.put("app.config.host",environment.getProperty("app.config.host"));
        map.put("java.home",environment.getProperty("java.home"));
        map.put("user.dir",environment.getProperty("user.dir"));
        return map;

    }

}
