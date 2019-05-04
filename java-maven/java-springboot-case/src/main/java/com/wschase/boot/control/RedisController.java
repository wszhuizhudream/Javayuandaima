package com.wschase.boot.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
@RestController
@RequestMapping(value = "redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/add")
    public Map<String,String> add(@RequestParam("key")String key, @RequestParam("value")String value){
        redisTemplate.opsForValue().set(key,value);
        Map<String,String> data=new HashMap<>();
        data.put(key,value);
        return data;
    }
}
