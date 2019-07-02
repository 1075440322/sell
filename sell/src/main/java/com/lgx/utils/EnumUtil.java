package com.lgx.utils;

import com.lgx.enums.CodeEnum;

/**
 * Created by Administrator on 2019/4/22.
 */
public class EnumUtil {

    public static  <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
