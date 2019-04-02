package com.wschase.songcianalysis.crawler.common;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
/**
 * Author:WSChase
 * Created:2019/3/28
 */
/**
 * 我们对于这个项目掌握以下的流程：
 * 为什么会有Page这个类，因为HtmlPage它的承载能力是有限的，它只能表示我们这个网页的文档信息，并不能
 * 告诉我们具体信息是什么，还有子页面有哪些，这个子页面是详情页还是文档页。所以我们对它进行一个包装，就有了Page；
 * 我们只需要通过Page将数据进行采集、解析、清晰，就可以把数据放到数据库里面去了。
 * 对于这个项目我们只要将这个爬虫的模块弄清除也可以，因为项目比较大，所以掌握一个模块并且完全弄懂就可以。
 * 对于那个架构图：一开始的原始数据就是我们的HtmlPage，然后到爬虫实现的这个蓝色框框就是传的我们自己定义的Page，我们自己
 * 定义的Page就是将网页的HtmlPage进行了包装并且加了很多属性，然后我们每经历一个爬虫的阶段，就给我们的某些属性赋值（比如：
 * 如果是一个文档的Page就指的是detail是false，到采集这一步只有base、path、detail三个属性有值，当到了解析以后html就有
 * 值了，然后采集完成之后就给属性赋值成功了，所以解析里面是有值的，解析过程中还会找到子页面。然后它会在子页面里面加一个
 * subPage然后subPage加完以后此时还是一个文档页面所以detail还是一个false，所以它不会经过清晰的阶段，所以我们将子页面
 * 加回我们的队列里面，再来对这个子页面做采集，这个时候我们的子页面（是刚才子页面的子页面）是detail为true的页面了；这个
 * 时候htmlPage属性又有值了，此时在当前页面已经没有子页面了，所以扭转到我们的清晰，清晰就可以用我们的JDBC写到数据库里面去
 * 了，这就是我们整个爬虫的核心，也是我们整个项目的核心。）
 *
 */
public class Page {

    //（1）因为有了lombok，所以直接写下面的标记就可以直接生成getter、setter方法了



//    //（2）或者直接采用下面的方法也可以直接生成getter、setter、toString方法


    /*
    *
    * 数据网站的跟地址
    * 比如：https://www.gushiwen.org
     */
    private final String base;

    /*
    *
    * 具体网页的路径:就是对于古诗文页面超链接点进去的页面
    * 比如：shiwenv_3e77840f88f6.aspx
     */
    private final String path;


    /*
    *标识网页是否是详情页
     */
    private final boolean detail;

    /*
    *网页DOM对象(文档对象模型)
     */
    private HtmlPage htmlPage;

    /*
    *子页面对象集合（就是超链接点击进去的页面）
     */
    private Set<Page> subPage=new HashSet<>();


    /**
     * 数据对象(数据集合)
     *
     * @return
     */
    private DataSet dataSet=new DataSet();


    /*
    *
    * 具体的网址=跟地址+域名
     */
    public String getUrl(){
        return this.base+this.path;
    }



    /**
     * 判断网页是否是详情页面
     * @return
     */
    public Boolean isDetail() {
        return this.detail;
    }

}
