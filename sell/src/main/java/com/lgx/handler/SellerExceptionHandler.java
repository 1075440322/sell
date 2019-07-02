package com.lgx.handler;

import com.lgx.VO.ResultVO;
import com.lgx.exception.SellException;
import com.lgx.exception.SellerAuthorizeException;
import com.lgx.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/5/16.
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        Map<String,Object> map = new HashMap<>();
        map.put("url","/sell/seller/product/login");
        return new ModelAndView("common/success",map);
    }

    /**
     * 这个方法捕获异常
     * 返回给前端
     * 后台控制台上不会显示出来
     * @param e
     * @return
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        //throw e;
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

}
