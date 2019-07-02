package com.lgx.controller;

import com.lgx.VO.ResultVO;
import com.lgx.converter.OrderForm2OrderDTOConverter;
import com.lgx.dto.OrderDTO;
import com.lgx.enums.ResultEnum;
import com.lgx.exception.SellException;
import com.lgx.form.OrderForm;
import com.lgx.service.BuyerService;
import com.lgx.service.OrderService;
import com.lgx.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/10.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    // 创建订单
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@Validated OrderForm orderForm,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确, orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[创建订单] 购物车不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        return ResultVOUtil.success(map);
    }

    // 订单列表
    @RequestMapping("/list")
    public ResultVO<List<OrderDTO>> list (@RequestParam("openid")String openid,
                                          @RequestParam(value = "page",defaultValue = "0")Integer page,
                                          @RequestParam(value = "size",defaultValue = "10")Integer size) {
        if (StringUtils.isEmpty(openid)){
            log.error("[查询订单列表] openid为空!");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        Pageable pageable = PageRequest.of(page,size);
        List<OrderDTO> orderDTOList =  orderService.findList(openid,pageable).getContent();



        return ResultVOUtil.success(orderDTOList);
    }


    // 订单详情
    @RequestMapping("/detial")
    public ResultVO<OrderDTO> detial(@RequestParam(value = "openid")String openid,
                                     @RequestParam(value="orderId")String orderId){



        if (StringUtils.isEmpty(openid)) {
            log.error("[查询订单详情] openId为空!");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            log.error("[查询订单详情] orderId为空!");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }


        OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);

        return ResultVOUtil.success(orderDTO);
    }



    // 取消订单
    @PostMapping("/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam(value = "openid")String openid,
                                     @RequestParam(value="orderId")String orderId){

        //TODO  验证必须本用户访问才能进行查看
        if (StringUtils.isEmpty(openid)) {
            log.error("[取消订单] openId为空!");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if (StringUtils.isEmpty(orderId)) {
            log.error("[取消订单] orderId为空!");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }


        buyerService.cancelOrder(openid,orderId);

        return ResultVOUtil.success(null);
    }

}
