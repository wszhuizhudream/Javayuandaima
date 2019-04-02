package com.wschase.songcianalysis.config;

import lombok.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**爬虫类
 * Author:WSChase
 * Created:2019/3/29
 */
@Data
public class ConfigProperties {
    //爬虫的base
    private String crawlerBase;
    //爬虫的path
    private String crawlerPath;
    private boolean crawlerDetail;

    private String dbUsername;
    private String dbPassword;
    private String dbUrl;
    private String dbDriverClass;

    private boolean enableConsole;


    public ConfigProperties(){
        //实例化的时候做一件事情：从外部文件去加载,然后将这些属性值进行赋值

        //将属性文件读取到
       InputStream inputStream = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties=new Properties();
        try {
            properties.load(inputStream);
       //     System.out.println(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.crawlerBase = String.valueOf(properties.get("crawler.base"));
        this.crawlerPath = String .valueOf(properties.get("crawler.path"));
        this.crawlerDetail = Boolean.parseBoolean(String.valueOf(properties.get("crawler.detail")));
        //剩下的四个
        this.dbUsername = String.valueOf(properties.get("db.username"));
        this.dbPassword = String.valueOf(properties.get("db.password"));
        this.dbUrl = String.valueOf(properties.get("db.url"));
        this.dbDriverClass = String.valueOf(properties.get("db.driver_class"));
        this.enableConsole=Boolean.valueOf(String.valueOf(properties.getProperty("config.enable_console","false")));


    }


}
