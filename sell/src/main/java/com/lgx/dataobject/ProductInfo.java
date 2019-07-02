package com.lgx.dataobject;

import com.lgx.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * Created by Administrator on 2019/3/21.
 */
@Entity
@Data
@DynamicUpdate   // update 自动更新
public class ProductInfo  {

    @Id
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

    // 商品状态
    private Byte productStatus = ProductStatusEnum.UP.getCode();

    // 类目编号
    private Integer categoryType;

    // 修改时间
    private Date updateTime;

    // 创建时间
    private Date createTime;





}
