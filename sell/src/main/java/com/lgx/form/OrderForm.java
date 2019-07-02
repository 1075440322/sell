package com.lgx.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Administrator on 2019/4/10.
 */
@Data
public class OrderForm {

    // 买家姓名
    @NotEmpty(message = "姓名必填")
    private String name;

    // 买家手机
    @NotEmpty(message = "手机必填")
    private String phone;

    // 买家地址
    @NotEmpty(message = "地址必填")
    private String address;

    // 买家openId
    @NotEmpty(message = "openId必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

}
