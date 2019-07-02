package com.lgx.service.impl;

import com.lgx.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/3/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl productCategoryServiceImpl;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory =productCategoryServiceImpl.findOne(1);
        System.out.println(productCategory);

    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = productCategoryServiceImpl.findAll();
        for (ProductCategory productCategory:list) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> ids = Arrays.asList(1,3);
        List<ProductCategory> list = productCategoryServiceImpl.findByCategoryTypeIn(ids);
        for (ProductCategory productCategory:list) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("振动棒",3);
        productCategoryServiceImpl.save(productCategory);
        System.out.println(productCategory);
    }

}