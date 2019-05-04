package com.wschase.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author:WSChase
 * Created:2019/4/29
 */
@ConfigurationProperties(prefix = "app.book")
@Component
@Data
public class BookProperties {
    private String author;
    private String name;
}
