package com.cp.cloud.eurekaclient.pay;

import java.math.BigDecimal;

/**
 * Description: 上下文
 *
 * @author chenpeng
 * @date 2019/2/27 17:42
 */
public class Context {

    private Strategry strategry;

    public BigDecimal calRecharge(Integer channlId, Integer goodsId) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //根据type 把实现类返回回来
        StrategryFactory strategryFactory = StrategryFactory.getInstance();
        strategry = strategryFactory.create(channlId);

        return strategry.calRecharge(channlId, goodsId);
    }
}
