package com.lgx.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lgx.dataobject.OrderDetail;
import com.lgx.enums.OrderStatusEnum;
import com.lgx.enums.PayStatusEnum;
import com.lgx.utils.EnumUtil;
import com.lgx.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/4/5.
 */


@Data
/*@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
  @JsonInclude(JsonInclude.Include.NON_NULL)
* 以上两个注解
* 当对象返回为null  ,不返回该字段
* 现在本项目已设置了全局所有字段返回时为null,都不返回
* */
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus ;

    private Integer payStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    //@JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    //@JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
