package com.cp.cloud.eurekaclient.pay.impl;

import com.cp.cloud.eurekaclient.pay.Pay;
import com.cp.cloud.eurekaclient.pay.Strategry;
import com.cp.cloud.eurekaclient.util.BeanUtil;

import java.math.BigDecimal;

/**
 * Description: 支付宝
 *
 * @author chenpeng
 * @date 2019/2/27 23:05
 */
@Pay(Pay.ZFB)
public class ZfbPay extends BeanUtil implements Strategry {

    @Override
    public BigDecimal calRecharge(Integer channlId, Integer goodsId) {
        return new BigDecimal(3);
    }
}
