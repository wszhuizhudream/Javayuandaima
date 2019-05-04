package com.wschase.boot.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**Spring boot部署到tomcat的写法
 * Author:WSChase
 * Created:2019/4/29
 */
@SpringBootApplication
public class ActionApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ActionApplication.class);
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(ActionApplication.class).run(args);
    }
}
