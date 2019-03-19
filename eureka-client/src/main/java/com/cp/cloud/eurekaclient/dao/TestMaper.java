package com.cp.cloud.eurekaclient.dao;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Description: test
 *
 * @author chenpeng
 * @date 2019/2/27 17:39
 */
@Repository
public class TestMaper {
    public BigDecimal count(){
        return new BigDecimal(2);
    }
}
