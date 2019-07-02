package com.lgx.service;

import com.lgx.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by Administrator on 2019/3/21.
 */
public interface ProductCategoryService {

    // 查找一个
    ProductCategory findOne(Integer id);

    // 查找所有
    List<ProductCategory> findAll();

    // 根据类目类型
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    // 保存
    ProductCategory save(ProductCategory productCategory);

}
