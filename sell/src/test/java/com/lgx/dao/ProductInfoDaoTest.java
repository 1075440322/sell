package com.lgx.dao;

import com.lgx.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/3/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;


    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("66");
        productInfo.setProductName("钻石刷头");
        productInfo.setCategoryType(10);
        productInfo.setProductDescription("非常好用的牙刷头");
        productInfo.setProductStatus(Byte.valueOf("1"));
        productInfo.setProductPrice(new BigDecimal(200));
        productInfo.setProductStock(20);
        productInfoDao.save(productInfo);

    }
    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> list= productInfoDao.findByProductStatus(Byte.valueOf("0"));
        for (ProductInfo productInfo : list) {
            System.out.println(productInfo);
        }
    }







}