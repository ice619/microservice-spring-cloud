package com.cp.cloud.serviceribbon.service;

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

    public String helloService(String name){
        return restTemplate.getForObject("http://eureka-client-hello/hello?name=" + name, String.class);
    }
}
