package com.cp.cloud.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Description: ribbon
 *
 * @author chenpeng
 * @date 2018/10/17 18:03
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String helloService(String name){
        return restTemplate.getForObject("http://eureka-client-hello/hello?name=" + name, String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
