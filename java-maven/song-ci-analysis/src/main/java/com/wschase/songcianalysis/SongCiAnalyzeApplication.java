package com.wschase.songcianalysis;


import com.wschase.songcianalysis.config.ObjectFactory;
import com.wschase.songcianalysis.crawler.Crawler;
import com.wschase.songcianalysis.web.WebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**宋词分析程序的主类
 * Author:WSChase
 * Created:2019/3/27
 */
public class SongCiAnalyzeApplication {
    //添加日志
    private static final Logger LOGGER=LoggerFactory.getLogger(SongCiAnalyzeApplication.class);

    public static void main(String[] args) {

//        //我们现在如果需要使用就通过对象工厂来使用
        WebController webController=ObjectFactory.getInstance().getObject(WebController.class);
        //运行了web服务，提供接口
        LOGGER.info("Web Server launch...");
        webController.launch();

        /**
         * 启动爬虫
         */
        if(args.length==1&&args[0].equals("run-crawler")){

        Crawler crawler=ObjectFactory.getInstance().getObject(Crawler.class);
        LOGGER.info("Crawler started...");
        crawler.start();
        }
    }
}
