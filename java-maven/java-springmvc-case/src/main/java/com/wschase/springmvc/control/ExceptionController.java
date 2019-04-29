package com.wschase.springmvc.control;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:WSChase
 * Created:2019/4/27
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping(value = "/greeting",method = RequestMethod.GET)
    public String greeting(@RequestParam("username")String username){
        if(StringUtils.isEmpty(username)){
            throw new RequestParamInvalidException();
        }
        return username;
    }
}
