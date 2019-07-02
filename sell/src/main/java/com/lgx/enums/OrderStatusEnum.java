package com.lgx.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2019/4/1.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEl(2,"已取消"),

    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
