package com.wschase.springmvc.control;

import com.wschase.springmvc.control.exception.GreetingException;
import com.wschase.springmvc.control.exception.RequestParamterInvalidException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**处理异常
 * Author:WSChase
 * Created:2019/5/4
 */

//1.抛一个用户自定义的异常
@RestController//控制器
@RequestMapping(value = "/exception",method = RequestMethod.GET)
public class ExceptionController {
    public String greeting(@RequestParam("username") String username){
        if(StringUtils.isEmpty(username)){
            //抛一个用户自定义的异常
            throw  new RequestParamterInvalidException();
        }
        return username;
    }

    //2.异常处理器
    @RequestMapping(value = "/greeting2",method = RequestMethod.GET)
    public String greeting2(@RequestParam("username") String username){
        throw new GreetingException("欢迎"+username+"发生错误");
    }


    @ExceptionHandler(value = {GreetingException.class})//只要抛出了这个异常它就会用这个方法来处理
    public ModelAndView greetingExecptionHandle(GreetingException e){
        String errorMessage=e.getMessage();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("error_message",errorMessage);
        modelAndView.setViewName("greeting error");
        return modelAndView;
    }

}
