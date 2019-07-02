package com.lgx.service.impl;

import com.lgx.dataobject.ProductInfo;
import com.lgx.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/3/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productInfoService.findOne("66");
        System.out.println(productInfo);

    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productInfoService.findUpAll();
        for (ProductInfo productInfo:list) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,1);
        Page<ProductInfo> page = productInfoService.findAll(pageRequest);
        System.out.println(page.getTotalElements());

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("77");
        productInfo.setProductName("黄金刷头");
        productInfo.setCategoryType(10);
        productInfo.setProductDescription("非常好用的牙刷头");
        productInfo.setProductStatus(Byte.valueOf("1"));
        productInfo.setProductPrice(new BigDecimal(200));
        productInfo.setProductStock(20);
        productInfoService.save(productInfo);

    }

    @Test
    public void onSale()throws Exception {

        ProductInfo productInfo = productInfoService.onSale("1");
        //Assert.assertTrue("上架成功能",productInfo.getProductStatus()==0);

    }

    @Test
    public void offSale()throws Exception {
        ProductInfo productInfo = productInfoService.offSale("66");
        //Assert.assertTrue("下架成功",productInfo.getProductStatus()==1);
    }

}