package com.lgx.service;

import com.lgx.dataobject.ProductInfo;
import com.lgx.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * Created by Administrator on 2019/3/21.
 */
public interface ProductInfoService {

    ProductInfo findOne(String productId);

    /**
     * 查询上架的产品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品分页
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    // 商品上架
    ProductInfo onSale(String productId);

    // 商品下架
    ProductInfo offSale(String productId);
}
