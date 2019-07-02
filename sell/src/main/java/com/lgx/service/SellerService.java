package com.lgx.service;

import com.lgx.dataobject.SellerInfo;

/**
 * Created by Administrator on 2019/5/7.
 */

public interface SellerService {
    /**
     * 通过卖家端openid查找用户
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
