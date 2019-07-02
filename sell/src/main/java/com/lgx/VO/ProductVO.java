package com.lgx.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品(包含类目)
 * Created by Administrator on 2019/3/25.
 */
@Data
public class ProductVO implements Serializable{


    private static final long serialVersionUID = -7179610493270785477L;
    // 前端定义的借口中为name,后端为防止出现取名混乱因此 加此注释保证前端字段名没有变化
    // 将category名转换成name
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
