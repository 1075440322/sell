package com.lgx.service;

import com.lgx.dto.OrderDTO;

/**
 * 买家
 * Created by Administrator on 2019/4/14.
 */
public interface BuyerService {

    // 查询一份订单
    OrderDTO findOrderOne(String openid,String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
