package com.lgx.dataobject.mapper;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.lgx.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //不知为何这里不加上的话WebSocketConfig报错
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put("category_name","???");
        map.put("category_type",99);
        int result = productCategoryMapper.insertByMap(map);
    }

    @Test
    public void insertByProductCategory() throws Exception {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("@!!!!!");
        productCategory.setCategoryType(88);
        int result = productCategoryMapper.insertByProductCategory(productCategory);

    }

    /**
     * 注意
     * 数据库中该字段名为category_type
     * 如果查找后不进行转换  查出的字段和实体对象中的名字不同  则结果为null
     * 注意在application.yml中配置
     * myBatis自动转换驼峰式命名
     * @throws Exception
     */
    @Test
    public void findByCategoryType() throws Exception {

        ProductCategory productCategory= productCategoryMapper.findByCategoryType(1);
        System.out.println(productCategory);
    }
    @Test
    public void findByCategoryName() throws Exception {

        List<ProductCategory> productCategorys= productCategoryMapper.findByCategoryName("???");
        for (ProductCategory productCategory:productCategorys) {
            System.out.println(productCategory.toString());
        }
    }

    @Test
    public void updateByCategoryName() throws Exception{
        int result = productCategoryMapper.updateByCategoryType(88,"请叫我小绿帽");

    }
    @Test
    public void updateByObject() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("@!!!!!");
        productCategory.setCategoryType(88);
        int result = productCategoryMapper.updateByObject(productCategory);

    }

    @Test
    public void delet() throws Exception{
        int result = productCategoryMapper.deleteByCategoryType(99);
        System.out.println(result);
    }

}