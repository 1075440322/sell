package com.lgx.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by Administrator on 2019/3/21.
 */
@Getter
public enum ProductStatusEnum {
    UP(Byte.valueOf("0"),"在架"),
    DOWN(Byte.valueOf("1"),"下架")
    ;
    private Byte code;
    private String message;

    ProductStatusEnum(Byte code, String message) {
        this.code = code;
        this.message = message;
    }


}
