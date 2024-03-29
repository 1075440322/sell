package com.lgx.aspect;

import com.lgx.constant.CookieConstant;
import com.lgx.constant.RedisConstant;
import com.lgx.exception.SellerAuthorizeException;
import com.lgx.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2019/5/14.
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public * com.lgx.controller.Seller*.*(..))"+
            "&& !execution(public * com.lgx.controller.SellerUserController.*(..))" )
    public void verify(){

    }


    @Before("verify()")
    public void doVerify(){

        // 获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("[登录校验] Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        // redis查询token
        String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("[登录校验] redis中查不到token");
            throw new SellerAuthorizeException();
        }


    }

}
