package com.lgx.dto;

import lombok.Data;

/**
 * 购物车
 * Created by Administrator on 2019/4/7.
 */
@Data
public class CartDTO {

    // 订单中商品Id
    private String productId;

    // 订单中商品的数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
