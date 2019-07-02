package com.lgx.controller;

import com.lgx.VO.ProductInfoVO;
import com.lgx.VO.ProductVO;
import com.lgx.VO.ResultVO;
import com.lgx.dataobject.ProductCategory;
import com.lgx.dataobject.ProductInfo;
import com.lgx.service.ProductCategoryService;
import com.lgx.service.ProductInfoService;
import com.lgx.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by Administrator on 2019/3/24.
 */
@RestController  // 设置整个类用json方式传递
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/sendMessage")
    public void sendMessage(@RequestParam(value = "message")String message){
        jmsTemplate.send("query1", new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(message);
                return textMessage;
            }
        });



    }




    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123")
    public ResultVO List() {

        // 1.查询所有上架商品
        List<ProductInfo> productInfos = productInfoService.findUpAll();

        // 2.查询类目(一次性查询)

        //List<Integer> ids = new ArrayList<>();
        // 传统方法
        //for (ProductInfo productInfo : productInfos) {
        //    ids.add(productInfo.getCategoryType());
        //}
        //java8 lambda表达式
        List<Integer> categoryTypeIds  = productInfos.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategories = productCategoryService.findByCategoryTypeIn(categoryTypeIds);


        // 3.数据拼装

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            //根据类目信息创建相应的productInfo
            for (ProductInfo productInfo : productInfos) {

                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
