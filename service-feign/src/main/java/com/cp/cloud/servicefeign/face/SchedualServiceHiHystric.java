package com.cp.cloud.servicefeign.face;

import org.springframework.stereotype.Component;

/**
 * Description: hystric断路器
 *
 * @author chenpeng
 * @date 2018/11/12 17:34
 */
@Component
public class SchedualServiceHiHystric implements SchedualeServiceHello {
    @Override
    public String sayHelloFromClient(String name) {
        return "sorry" + name;
    }
}
