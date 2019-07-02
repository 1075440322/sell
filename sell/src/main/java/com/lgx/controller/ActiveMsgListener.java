package com.lgx.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2019/6/27.
 */
@Controller
public class ActiveMsgListener {

    @JmsListener(destination = "query1")
    public void rctiveMsg(String message) {
        System.out.println("----成功监听到数据-----"+message);
    }
}
