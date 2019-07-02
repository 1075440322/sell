package com.lgx.dao;

import com.lgx.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/4/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String openId = "abc";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("222");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerPhone("15166055772");
        orderMaster.setBuyerOpenid("abc");
        orderMaster.setOrderAmount(new BigDecimal(3));
        OrderMaster result = orderMasterDao.save(orderMaster);
        System.out.println(result);

    }

    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest pageRequest = PageRequest.of(1,3) ;
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(openId, pageRequest);
        System.out.println(result.getContent());

    }


}