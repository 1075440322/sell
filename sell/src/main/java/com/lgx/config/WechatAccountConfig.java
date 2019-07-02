package com.lgx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/4/16.
 */

@ConfigurationProperties(prefix = "wechat")
@Component
@Data
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

}
