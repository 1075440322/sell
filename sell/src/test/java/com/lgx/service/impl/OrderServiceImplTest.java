package com.lgx.service.impl;

import com.lgx.dataobject.OrderDetail;
import com.lgx.dto.OrderDTO;
import com.lgx.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID = "666";
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerName("lgx");
        orderDTO.setBuyerOpenid("666");
        orderDTO.setBuyerPhone(BUYER_OPENID);

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("66");
        o2.setProductQuantity(1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}", result);


    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1554627971020772299");
        log.info("[查询订单] result={}", orderDTO);
        System.out.println(orderDTO);


    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage =  orderService.findList("666",pageRequest);

    }

    @Test
    public void cancel() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1554627971020772299");
        OrderDTO result = orderService.cancel(orderDTO);
        //Assert.assertEquals(OrderStatusEnum.CANCEl.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1554627971020772299");
        OrderDTO result = orderService.finish(orderDTO);
        //Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());

    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1554627971020772299");
        OrderDTO result = orderService.paid(orderDTO);
        //Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage =  orderService.findList(pageRequest);
        //Assert.assertTrue("查询所有订单列表",orderDTOPage.getTotalElements() > 0);


    }

}