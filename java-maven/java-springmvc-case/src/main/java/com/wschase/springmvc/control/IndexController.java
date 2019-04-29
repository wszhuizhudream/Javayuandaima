package com.wschase.springmvc.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
