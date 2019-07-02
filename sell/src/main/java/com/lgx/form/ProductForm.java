package com.lgx.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/5/3.
 */
@Data
public class ProductForm {

    // 产品Id
    private String productId;

    // 产品名称
    private String productName;

    // 商品价格
    private BigDecimal productPrice;

    // 商品库存
    private Integer productStock;

    // 商品描述
    private String productDescription;

    // 商品图片(小)
    private String productIcon;


    // 类目编号
    private Integer categoryType;
}
