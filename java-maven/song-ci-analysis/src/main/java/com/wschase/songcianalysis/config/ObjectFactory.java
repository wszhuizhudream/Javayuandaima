package com.wschase.songcianalysis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.wschase.songcianalysis.analyze.dao.AnalyzeDao;
import com.wschase.songcianalysis.analyze.dao.impl.AnalyzeDaoImpl;
import com.wschase.songcianalysis.analyze.service.AnalyService;
import com.wschase.songcianalysis.analyze.service.impl.AnalyzeServiceImpl;
import com.wschase.songcianalysis.crawler.Crawler;
import com.wschase.songcianalysis.crawler.common.Page;
import com.wschase.songcianalysis.crawler.parse.DataPageParse;
import com.wschase.songcianalysis.crawler.parse.DocumentParse;
import com.wschase.songcianalysis.crawler.pipeline.ConsolePipeline;
import com.wschase.songcianalysis.crawler.pipeline.DatabasePipeline;
import com.wschase.songcianalysis.web.WebController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**对象工厂：这里面只关心我们的对象
 * Author:WSChase
 * Created:2019/3/31
 */
public class ObjectFactory {
    /**
     * 我们需要一个工厂对象，所以我们实现一个单例——通过饿汉式
     */
    private static final ObjectFactory instance=new ObjectFactory();

    private final Logger logger=LoggerFactory.getLogger(ObjectFactory.class);

    /**
     *因为对象比较多所以我们将对象放到一个集合里面去
     */

    private final Map<Class,Object> objectHashMap =new HashMap<>();

    private ObjectFactory(){
        //1.初始化配置对象
        initConfigProperties();

        //2.创建数据源对象
        initDataSource();

        //3.爬虫对象
        initCrawler();

        //4.Web对象
        initWebController();

        //5.对象清单打印输出
        printObjectList();

    }

    /**
     * Web对象
     */
    private void initWebController() {
        //需要service
        DataSource dataSource=getObject(DataSource.class);
        AnalyzeDao analyzeDao=new AnalyzeDaoImpl(dataSource);
        AnalyService analyService=new AnalyzeServiceImpl(analyzeDao);
        WebController webController=new WebController(analyService);

        objectHashMap.put(WebController.class,webController);
    }

    /**
     * 爬虫对象
     */
    private void initCrawler() {
        ConfigProperties configProperties=getObject(ConfigProperties.class);
        DataSource dataSource=getObject(DataSource.class);
        //直接将所有的方法放到构造方法里面
        final Page page=new Page(
                configProperties.getCrawlerBase(),
                configProperties.getCrawlerPath(),
                configProperties.isCrawlerDetail()
        );

        Crawler crawler=new Crawler();
        //爬虫的核心是下面的三个类的实现：
        crawler.addParse(new DocumentParse());
        crawler.addParse(new DataPageParse());
       if(configProperties.isEnableConsole()){
            //如果是true我们才加入到管道中
        crawler.addPipeline(new ConsolePipeline());
       }
        crawler.addPipeline(new DatabasePipeline(dataSource));
        crawler.addPage(page);

        objectHashMap.put(Crawler.class,crawler);
    }

    /**
     * 创建数据源对象
     */
    private void initDataSource() {
        //通过我们上面创建的静态方法就可以获取到这个对象
        ConfigProperties configProperties=getObject(ConfigProperties.class);
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername(configProperties.getDbUsername());
        dataSource.setPassword(configProperties.getDbPassword());
        dataSource.setDriverClassName(configProperties.getDbDriverClass());
        dataSource.setUrl(configProperties.getDbUrl());

        //将数据源放进集合里面
        objectHashMap.put(DataSource.class,dataSource);
    }

    /**
     * 初始化配配置对象
     */
    private void initConfigProperties() {
        ConfigProperties configProperties=new ConfigProperties();
        //将对象实例化以后就将它放进我们拿到集合里面去
        objectHashMap.put(ConfigProperties.class,configProperties);

        //打印配置信息，可以知道是否配错
        logger.info("ConfigProperties info:\n{}",configProperties.toString());
    }

    //对象存进去了以后我们也要能够取到对象——泛型方法
    public <T> T  getObject(Class classz){
        if(!objectHashMap.containsKey(classz)){
            throw new IllegalArgumentException("Class"+classz.getName()+"not found Object");
        }
        return (T) objectHashMap.get(classz);
    }


    public static ObjectFactory getInstance(){
        return instance;
    }

    private void printObjectList(){
        logger.info("=========ObjectFactory List=========\n");
        for(Map.Entry<Class,Object> entry:objectHashMap.entrySet()){
            logger.info(String.format("\t\t[%s]==>[%s]",entry.getKey().getCanonicalName(),entry.getValue().getClass().getCanonicalName()));
        }
        logger.info("====================================\n");
    }
}
