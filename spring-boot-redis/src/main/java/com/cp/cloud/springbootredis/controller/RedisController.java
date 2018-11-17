package com.cp.cloud.springbootredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: test Redis
 *
 * @author chenpeng
 * @date 2018/11/16 14:42
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/setValue")
    public String setValue(){

        if(!template.hasKey("maoqiu")){
            template.opsForValue().append("maoqiu","我是毛球");
            return "使用redis缓存保存数据成功";
        }else {
            template.delete("maoqiu");
            return "key已存在";
        }
    }

    @RequestMapping("/getValue")
    public String getValue(){
        if(!template.hasKey("maoqiu")){
            return "key不存在";
        }else {
            String value = template.opsForValue().get("maoqiu");
            return "获取到缓存中的数据：maoqiu="+value;
        }
    }
}
