package com.lgx.dao;

import com.lgx.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2019/3/21.
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    // 根据商品的状态查找
    List<ProductInfo> findByProductStatus(Byte ProductStatus);

}
