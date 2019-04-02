package com.wschase.songcianalysis.crawler;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.wschase.songcianalysis.crawler.common.Page;
import com.wschase.songcianalysis.crawler.parse.Parse;
import com.wschase.songcianalysis.crawler.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**爬虫框架
 * Author:WSChase
 * Created:2019/3/28
 */
public class Crawler {

    //添加一个日志
    private final Logger logger=LoggerFactory.getLogger(Crawler.class);

    /*
    *放置文档页面（超链接）
    *
    * 未被采集和解析的页面
    * Page htmlPage dataSet
     */
    private Queue<Page> docQueue=new LinkedBlockingQueue<>();

    /*
    *放置详情页面(处理完成，数据在dataSet)
     */
    private  final Queue<Page> detailQueue=new LinkedBlockingQueue<>();

    /**
     * 采集器
     */
    private final WebClient webClient;


    /**
     * 所有的解析器
     */
    private final List<Parse> parseList=new LinkedList<>();

    /**
     * 所有的清洗器（管道）
     */
    private  final List<Pipeline> pipelineList=new LinkedList<>();

    /**
     * 线程调度器
     */
    private  final ExecutorService executorService;

    public Crawler (){
        this.webClient=new WebClient(BrowserVersion.CHROME);
        this.webClient.getOptions().setJavaScriptEnabled(false);

        //创建一个线程执行器（线程工厂）
        this.executorService=Executors.newFixedThreadPool(8, new ThreadFactory() {
            private final AtomicInteger id=new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("Crawler-Thread-"+id.getAndIncrement());
                return thread;
            }
        });

    }

    /**
     * 启动爬虫
     */
    public void start(){

        //爬取：各自执行各自的
        this.executorService.submit(new Runnable() {
            @Override
            public void run() {
                //线程已启动就去解析
                parse();
            }
        });

        //解析:各自执行各自的
        this.executorService.submit(new Runnable() {
            @Override
            public void run() {
                pipeline();
            }
        });
    }

    //清晰


    public void parse() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               //异常处理:{}表示占位符，它会将getMassage放在大括号里面，如果是多个就继续写大括号就可以了，
                // 这个地方是一个可变参数。
                logger.error("Parse occur execption {}.",e.getMessage());
            }

            final Page page = this.docQueue.poll();
            if (page == null) {
                continue;
            }
            //文档出队列：返回page
            this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //采集
                        //因为这个地方是个匿名内部类：它的类名是外部类.内部类
                        HtmlPage htmlPage = Crawler.this.webClient.getPage(page.getUrl());
                        page.setHtmlPage(htmlPage);

                        for (Parse parse : Crawler.this.parseList) {
                            parse.parse(page);
                        }
                        //是详情
                        if(page.isDetail()){
                            Crawler.this.detailQueue.add(page);
                        }else {
                            //不是详情
                            Iterator<Page> iterator=page.getSubPage().iterator();
                            while(iterator.hasNext()){
                                Page subPage=iterator.next();
                                Crawler.this.docQueue.add(subPage);
                                iterator.remove();
                            }
                        }
                    } catch (IOException e) {
                        logger.error("Parse task occur execption {}.",e.getMessage());
                    }
                }
            });
        }
    }



    public void pipeline(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("Parse occur execption {}.",e.getMessage());
            }
            final Page page=this.detailQueue.poll();
            if(page==null){
                continue;
            }
            this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for(Pipeline pipeline:Crawler.this.pipelineList){
                        pipeline.pipeline(page);
                    }
                }
            });
        }
    }

    public void addPage(Page page){
        this.docQueue.add(page);
    }
    public  void addParse(Parse parse){
        this.parseList.add(parse);
    }
    public void addPipeline(Pipeline pipeline){
        this.pipelineList.add(pipeline);
    }

    /**
     * 停止爬虫
     */
    public void stop(){
       if(this.executorService!=null&&!this.executorService.isShutdown()){
           this.executorService.isShutdown();
       }
       logger.info("Crawler stoped...");
    }
}
