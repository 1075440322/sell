package com.lgx.dao;

import com.lgx.dataobject.SellerInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/5/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setId("111");
        sellerInfo.setOpenid("ccdd");
        sellerInfo.setUsername("li");
        sellerInfo.setPassword("111");
        SellerInfo result = sellerInfoDao.save(sellerInfo);
        System.out.println(result);
    }
    @Test
    public void findByOpenid() throws Exception {
        SellerInfo sellerInfo = sellerInfoDao.findByOpenid("aabbcc");
        System.out.println(sellerInfo);

    }

}