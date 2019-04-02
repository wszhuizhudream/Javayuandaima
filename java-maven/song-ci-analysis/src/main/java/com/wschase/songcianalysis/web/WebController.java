package com.wschase.songcianalysis.web;

import com.google.gson.Gson;
import com.wschase.songcianalysis.analyze.model.AuthorCount;
import com.wschase.songcianalysis.analyze.service.AnalyService;
import com.wschase.songcianalysis.analyze.service.WordCount;
import com.wschase.songcianalysis.config.ObjectFactory;
import com.wschase.songcianalysis.crawler.Crawler;
import spark.*;

import java.util.List;

/**Web API
 *
 * （1）目前的这个项目是通过Sparkjava框架完成Web API开发
 * （2）此外还有Servlet技术实现Web API的开发
 * （3）Java-Httpd实现Web API（纯java语言实现的web服务器）
 *    用到的技术：
 *         Socket技术、Http协议非常清楚
 * Author:WSChase
 * Created:2019/3/31
 */
public class WebController {
    private final AnalyService analyService;

    public WebController(AnalyService analyService) {
        this.analyService = analyService;
    }

    //->http://127.0.0.1:4567/
    //->/analyze/author_count
    //->/analyze/word_cloud
    private List<AuthorCount> analyAuthorCount(){
        return analyService.analyzeAuthorCount();
    }

    //词云
    private List<WordCount> analyzeWordCount(){
        //分析并返回词云
        return analyService.analyzeWordCloud();
    }

    //运行Web
    public void launch(){
        ResponseTransformer jsonResponseTransformer=new JSONResponseTransformer();

        //前端静态文件的目录：
        //src/main/resources/static
        Spark.staticFileLocation("/static");

        Spark.get("analyze/author_count",
                ((request, response) -> analyAuthorCount()),jsonResponseTransformer);

        Spark.get("analyze/word_cloud",
                ((request, response) -> analyzeWordCount()),jsonResponseTransformer);


        //爬虫停止:也可以通过按钮的形式来停止爬虫
        Spark.get("/crawler/stop",(((request, response) -> {
            Crawler crawler=ObjectFactory.getInstance().getObject(Crawler.class);
            crawler.stop();
            return "爬虫停止";
        })));
    }

    /**
     * 我们现在的目的就是将一个java对象转化为一个字符串
     */
    public static class JSONResponseTransformer implements ResponseTransformer{

        //Object->String
        private Gson gson=new Gson();


        @Override
        public String render(Object o) throws Exception {
            return gson.toJson(o);
        }
    }

}
