package com.cp.cloud.serviefeign.face;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cp on 2018/10/17.
 */
@FeignClient(value = "eureka-client-hello")
public interface SchedualeServiceHello {

    @RequestMapping(value = "/hello")
    String sayHelloFromClient(@RequestParam(value = "name") String name);
    //这里@RequestParam String name  不行，必须写value = "name"不知道为啥
}
