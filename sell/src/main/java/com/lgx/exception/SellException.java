package com.lgx.exception;

import com.lgx.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by Administrator on 2019/4/5.
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }

}
