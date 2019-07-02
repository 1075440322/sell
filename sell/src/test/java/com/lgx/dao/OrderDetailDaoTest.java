package com.lgx.dao;

import com.lgx.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2019/4/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("124");
        orderDetail.setOrderId("111");
        orderDetail.setProductId("2");
        orderDetail.setProductName("电动牙刷头");
        orderDetail.setProductPrice(new BigDecimal(10));
        orderDetail.setProductQuantity(1);
        OrderDetail result = orderDetailDao.save(orderDetail);
        System.out.println(result);



    }


    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> list =  orderDetailDao.findByOrderId("111");
        System.out.println(list);

    }

}