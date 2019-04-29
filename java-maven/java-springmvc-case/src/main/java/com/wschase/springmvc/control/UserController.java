package com.wschase.springmvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Author:WSChase
 * Created:2019/4/27
 */
@Controller
@RequestMapping(value = "/user")
//只要是以/user的url都可以到达这个UserController的里面进行处理
public class UserController {

    private static final String CURRENT_USER="current_user";

    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public ModelAndView login(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("login username="+username+",password="+password);
        HttpSession session=request.getSession();
        session.setAttribute(CURRENT_USER,username);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("username",username);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = {"/login"},method = {RequestMethod.GET})//只要你GET一下就会返回一个登录页面
    //这个表示以这三个开头的都可以到这个方法里面
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("welcome");//WEB-INF/views/login.jsp
        //返回一个页面
        return modelAndView;
    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET})
    public ModelAndView logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute(CURRENT_USER);//清理当前用户
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");//WEB-INF/views/login.jsp
        //返回一个页面
        return modelAndView;
    }
}
