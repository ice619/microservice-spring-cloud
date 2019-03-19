package com.cp.cloud.eurekaclient.pay.impl;

import com.cp.cloud.eurekaclient.enums.PayType;
import com.cp.cloud.eurekaclient.pay.Pay;
import com.cp.cloud.eurekaclient.pay.Strategry;
import com.cp.cloud.eurekaclient.dao.TestMaper;
import com.cp.cloud.eurekaclient.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Description: 工商银行通道
 *
 * @author chenpeng
 * @date 2019/2/27 17:35
 */
@Pay(Pay.ZFB)
public class ICBCPay extends BeanUtil implements Strategry {

    @Autowired
    private TestMaper testMaper;

    @Override
    public BigDecimal calRecharge(Integer channlId, Integer goodsId) {
        PayType.ZFB.getValue();
        return testMaper.count();
    }
}
