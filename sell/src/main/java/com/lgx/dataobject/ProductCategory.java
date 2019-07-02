package com.lgx.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目商品
 * Created by Administrator on 2019/3/19.
 * 数据库表:product_category
 */
@Entity
@DynamicUpdate  // 使数据库中动态更新  这里主要使时间更新
@Data   // lombok 插件的注解  data包括getset和toString
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id 根据底层数据库中的自增长;
    private Integer categoryId;

    // 类目名称
    private String categoryName;

    // 类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
