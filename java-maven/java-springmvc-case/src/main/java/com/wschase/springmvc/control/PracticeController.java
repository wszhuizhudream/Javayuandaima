package com.wschase.springmvc.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**SpringMVC练习
 * Author:WSChase
 * Created:2019/4/27
 */
@Controller
@RequestMapping(value = "/")
public class PracticeController {

    @Autowired
    private PracticeController practiceController;

    //对于GET请求没有正文
    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("datetime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return modelAndView;
    }
}
