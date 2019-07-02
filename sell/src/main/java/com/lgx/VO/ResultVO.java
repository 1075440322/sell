package com.lgx.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Created by Administrator on 2019/3/25.
 */
@Data
public class ResultVO<T> implements Serializable{


    private static final long serialVersionUID = 156157462664918128L;
    // 错误码
    private Integer code;

    // 错误信息
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}


/*
{
        "code": 0,
        "msg": "成功",
        "data": [
        {
        "name": "热榜",
        "type": 1,
        "foods": [
        {
        "id": "123456",
        "name": "皮蛋粥",
        "price": 1.2,
        "description": "好吃的皮蛋粥",
        "icon": "http://xxx.com",
        }
        ]
        },
        {
        "name": "好吃的",
        "type": 2,
        "foods": [
        {
        "id": "123457",
        "name": "慕斯蛋糕",
        "price": 10.9,
        "description": "美味爽口",
        "icon": "http://xxx.com",
        }
        ]
        }
        ]
        }*/
