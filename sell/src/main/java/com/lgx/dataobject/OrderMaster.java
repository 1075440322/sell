package com.lgx.dataobject;

import com.lgx.enums.OrderStatusEnum;
import com.lgx.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2019/4/1.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

    // 1.该集合在数据库中没有对应关系  如果想避免可以使用@Transient  这个注解忽略该对象
    // 2.建议新建一个新的对象
    //private List<OrderDetail> orderDetailList;


}
