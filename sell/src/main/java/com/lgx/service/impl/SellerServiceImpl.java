package com.lgx.service.impl;

import com.lgx.dao.SellerInfoDao;
import com.lgx.dataobject.SellerInfo;
import com.lgx.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/5/7.
 */
@Service
@Slf4j
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {

        SellerInfo sellerInfo = sellerInfoDao.findByOpenid(openid);
        /*if (sellerInfo == null) {
            throw new SellException(ResultEnum.SELLERINFO_NOT_EXIST);
        }*/
        return sellerInfo;
    }
}
