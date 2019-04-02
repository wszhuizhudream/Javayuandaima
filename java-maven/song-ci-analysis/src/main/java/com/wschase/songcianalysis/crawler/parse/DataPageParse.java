package com.wschase.songcianalysis.crawler.parse;

import com.gargoylesoftware.htmlunit.html.*;
import com.wschase.songcianalysis.crawler.common.Page;

/**详情页面解析——对数据进行解析
 * Author:WSChase
 * Created:2019/3/28
 */

public class DataPageParse implements Parse{

    @Override
    public void parse(final Page page) {
        //如果不是详情页面，我们不解析；
        if(!page.isDetail()){
            return;
        }

        HtmlPage htmlPage=page.getHtmlPage();
        HtmlElement body=htmlPage.getBody();

        //标题
        String titlePath="//div[@class='cont']/h1/text()";
        DomText titleDom=((DomText)body.getByXPath(titlePath).get(0));
        String title=titleDom.asText();

        //朝代
        String dynastyPath="//div[@class='cont']/p/a[1]";
        HtmlAnchor dynastyDom=(HtmlAnchor)body.getByXPath(dynastyPath).get(0);
        String dynasty=dynastyDom.asText();


        //作者
        String authorPath="//div[@class='cont']/p/a[2]";
        HtmlAnchor authorDom=(HtmlAnchor)body.getByXPath(authorPath).get(0);
        String author=authorDom.asText();


        //内容:不能取id来获取正文，因为在不同的页面它的id可能不一样，但是结构（网页格式）是一样的
        String contentPath="//div[@class='cont']/div[@class='contson']";
        HtmlDivision htmlDivision=(HtmlDivision)body.getByXPath(contentPath).get(0);
        String content=htmlDivision.getTextContent();


//        //包装成一个类:将网页解析完成之变成一个对象，将这个对象装在数据库里面
//        SongCiInfo poerty=new SongCiInfo();
//        poerty.setTitle(title);
//        poerty.setDynasty(dynasty);
//        poerty.setAuthor(author);
//        poerty.setContent(content);

        //修改解析数据：
        page.getDataSet().putData("title",title);
        page.getDataSet().putData("dynasty",dynasty);
        page.getDataSet().putData("author",author);
        page.getDataSet().putData("content",content);

        //更多数据
        page.getDataSet().putData("url",page.getUrl());






    }
}
