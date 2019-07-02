package com.lgx.dao;

import com.lgx.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Administrator on 2019/3/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){

        /*List<ProductCategory> list = productCategoryDao.findAll();
        for (ProductCategory productCategory: list ) {
            System.out.println(productCategory.toString());
        }*/

        ProductCategory productCategory = productCategoryDao.findById(1).get();
        //productCategory.setCategoryType(10);
        //productCategoryDao.save(productCategory);
        System.out.println(productCategory.toString());

    }
    @Test
    // @Transactional  该注解是在测试结束后事物回滚  这样就不会在数据库中产生记录
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("篮球",3);
        //productCategory.setCategoryName("咖啡机");
        // productCategory.setCategoryType(1);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void  findByCategoryTypeInTest(){

        List<Integer> types = Arrays.asList(1,1,10);

        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(types);
        System.out.println("结果长度: "+result.size());

    }

}