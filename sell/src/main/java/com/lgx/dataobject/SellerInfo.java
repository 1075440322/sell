package com.lgx.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2019/5/7.
 */
@Entity
@Data
public class SellerInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;
}
