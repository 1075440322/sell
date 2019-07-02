package com.lgx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2019/5/26.
 */
@Component
@Slf4j
/**
 * 分布式锁的应用
 */
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redis加锁
     * @param key  当前使用的是产品的ID
     * @param value 当前时间+过期时间
     * @return 返回true表示已设置新锁   false则表示锁设置失败
     */
    public boolean lock(String key,String value) {

        // setIfAbsent是相当于redis命令中的SETNX key value
        // 如果返回true 表示可以设置 1
        // 如果返回false 表示不能设置 0
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        // 获取当前存在redis中的值
        String currentValue = stringRedisTemplate.opsForValue().get(key);

        // 判断当前redis中的值已经过期
        if (!StringUtils.isEmpty(currentValue) && Long.valueOf(currentValue)< System.currentTimeMillis()){

            // 设置当前时间值并返回上次的时间值
            // 将上次时间值与currentValue比较  如果相同者表示新的锁设置成功
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }

        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unLock(String key,String value) {

        try {
            String currentlyValue = stringRedisTemplate.opsForValue().get(key);

            // 获取当前redis中锁的时间与传入的value进行比较如果相同就删除
            if (!StringUtils.isEmpty(currentlyValue) && currentlyValue.equals(value)){
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("[redis分布式锁] 解锁异常,{}", e);
        }


    }






}
