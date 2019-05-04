package com.wschase.springmvc.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:WSChase
 * Created:2019/4/26
 */
@RequestMapping
public class IndexController {

    @RequestMapping(value = {"","/index"},method = {RequestMethod.GET})
    public ModelAndView hello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("welcome");//WEB-INF/views/login.jsp
        return modelAndView;
    }


    //（1）如果加这个那么返回的是视图，String代表的响应页面
    //@RequestMapping(value = "/index",method = {RequestMethod.GET})
    //（2）如果加这个那么返回的是字符串，String代表的就是响应内容
    @ResponseBody
    public String welcome(){
        return "index";//WEB-INF/views/welcome.jsp
    }

}
