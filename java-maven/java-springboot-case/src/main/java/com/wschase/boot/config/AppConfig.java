package com.wschase.boot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**属性配置
 * Author:WSChase
 * Created:2019/4/29
 */
@PropertySource(value={"classpath:appconfig.properties"})
@Data
@Component
public class AppConfig {
    @Value("${app.config.host}")
    private String host;

    @Value("${app.config.port}")
    private Integer port;



}
