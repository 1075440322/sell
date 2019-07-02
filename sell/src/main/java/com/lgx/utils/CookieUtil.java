package com.lgx.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie工具类
 * Created by Administrator on 2019/5/13.
 */
public class CookieUtil {

    private static  HttpServletResponse responseResult = null;

    /**
     * 设置token
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,
                           String name,String value, int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        responseResult = response;
    }

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return

    public static Cookie get(HttpServletRequest request,String name){

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie :cookies){
            if (cookie.getName() == name){
                return cookie;
            }
        }
        return null;
    }
     */

    /**
     * 获取cookie
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,String name){
        Map<String,Cookie> map = readCookieMap(request);
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }

    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){

        Map<String,Cookie> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                map.put(cookie.getName(),cookie);
            }
        }
        return map;
    }
}
