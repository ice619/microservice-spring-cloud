package com.cp.cloud.servicefeign.controller;

import com.cp.cloud.servicefeign.face.SchedualeServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: feign
 *
 * @author chenpeng
 * @date 2018/10/17 19:36
 */
@RestController
public class HelloController {

    @Autowired
    SchedualeServiceHello schedualeServiceHello;

    @RequestMapping(value = "/hello")
    public String sayHello(@RequestParam String name){
        System.out.println("feign...");
        return schedualeServiceHello.sayHelloFromClient(name);
    }
}
