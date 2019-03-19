package com.cp.cloud.eurekaclient.controller;

import com.cp.cloud.eurekaclient.pay.Context;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Description: order
 *
 * @author chenpeng
 * @date 2019/2/27 21:07
 */
@RestController
public class OrderController{

    @RequestMapping(value = "/order")
    public String  order() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Context context = new Context();
        BigDecimal bigDecimal = context.calRecharge(1, 1);
        return bigDecimal.toString();
    }

}