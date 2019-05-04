package com.wschase.springmvc.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ReqestMapping 来处理消息头
 *  * 表示必须带这个头才可以进行处理
 *  有问题：执行结果404
 * Author:WSChase
 * Created:2019/5/3
 */
@RestController
@RequestMapping(value = "/demo3")
public class Demo2Controller {

    //表示这个方法处理的一定是包含这个头的文件
    @RequestMapping(value = "/head3",headers = {
            "context-type=text/html"
    })
    public String textPlain(){
        return "Hello world";
    }

}
