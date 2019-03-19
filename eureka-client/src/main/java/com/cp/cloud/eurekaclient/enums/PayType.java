package com.cp.cloud.eurekaclient.enums;

/**
 * Created by cp on 2019/2/27.
 */
public enum PayType {

    ZFB(1, "支付宝"),
    WX(2, "微信"),
    ;
    
    private int value;
    private String desc;

    PayType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
