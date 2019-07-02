package com.lgx.utils;

import java.util.Random;

/**
 * Created by Administrator on 2019/4/5.
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式:时间+随机数
     * 防止多线程加入同步字段
     * @return
     */
    public static synchronized String getUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
