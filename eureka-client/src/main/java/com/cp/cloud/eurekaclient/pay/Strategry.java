package com.cp.cloud.eurekaclient.pay;

import java.math.BigDecimal;

/**
 * Created by cp on 2019/2/27.
 */
public interface Strategry {

    /**
     * 计算支付金额
     * @param channlId
     * @param goodsId
     * @return
     */
    BigDecimal calRecharge(Integer channlId, Integer goodsId);
}
