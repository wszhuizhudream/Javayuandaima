package com.wschase.springmvc.control;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:WSChase
 * Created:2019/4/27
 */

@RestController
@RequestMapping(value = "/controller")
public class Demo2Controller {
    @RequestMapping(value = "/header")
    public String header(
    @RequestHeader(value = "Accept-Encoding") String encoding,
    @RequestHeader(value = "Keep-Alive") int alive
    ){
        return String.format("Accept-Encoding:%s,Keep-Alive:%d",encoding,alive);
    }
}
