package com.lgx.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2019/4/5.
 */
@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),

    PARAM_ERROR(1,"参数不正确"),

    PRODUCT_NOT_EXIST(10,"商品不存在!"),

    PRODUCT_STOCK_ERROR(11,"商品库存异常!"),

    ORDER_NOT_EXIST(12,"订单不存在!"),

    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在!"),

    ORDER_STATUS_ERROR(14,"订单状态不正确!"),

    ORDER_UPDATE_FAIL(15,"订单更新失败!"),

    ORDER_DETAIL_EMPTY(16,"订单详情为空!"),

    ORDER_PAY_STATUS_ERROR(17,"订单支付装态不正确!"),

    CART_EMPTY(18,"购物车不能为空!"),

    ORDER_OWNER_ERROR(19,"该订单不属于当前用户!"),

    WX_MP_ERROR(20,"微信公众账号方面错误!"),

    ORDER_CANCEL_SUCCESS(22,"订单取消成功!"),

    ORDER_FINISH_SUCCESS(23,"订单完结成功!"),

    PRODUCT_STATUS_ERROR(24,"商品状态不正确!"),

    SELLER_INFO_NOT_EXIST(25,"用户不存在!"),

    LOGIN_FAIL(26,"用户登录失败!"),

    LOGOUT_SUCCESS(27,"用户登出成功")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
