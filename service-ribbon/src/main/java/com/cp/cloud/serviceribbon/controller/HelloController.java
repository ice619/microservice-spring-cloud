package com.cp.cloud.serviceribbon.controller;

import com.cp.cloud.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: ribbon
 *
 * @author chenpeng
 * @date 2018/10/17 18:08
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String hi(@RequestParam String name){
        System.out.println("ribbon...");
        return helloService.helloService(name);
    }

}
