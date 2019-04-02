package com.wschase.songcianalysis.crawler.parse;

import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.wschase.songcianalysis.crawler.common.Page;

import java.util.concurrent.atomic.AtomicInteger;

/**链接解析
 * Author:WSChase
 * Created:2019/3/28
 */
public class DocumentParse implements Parse{


    //这个说明我们现在取的是url地址
    @Override
    public void parse(Page page) {
        if(page.isDetail()){
            return;
        }

        //这个地方如果因为要使用final所以不能用int，因为final修饰的属性不可以修改，所以我们用一个原子的属性
         AtomicInteger count=new AtomicInteger(0);
        HtmlPage htmlPage=page.getHtmlPage();

        //通过分析发现我的超链接都在div里面的，都是由typecont修饰，所以通过解析我将所有的超链接都取出来
        htmlPage.getBody()
                .getElementsByAttribute("div","class","typecont")
                .forEach(div -> {
//                    //（1）打印标题
//                    System.out.println(htmlElement.asText());

//                        //（2)打印结构
//                        System.out.println(htmlElement.asXml());

                    //(3)取出超链接
                    DomNodeList<HtmlElement> aNodeList=div .getElementsByTagName("a");
                    aNodeList.forEach(
                            aNode -> {

                                //这个就是超链接，就是我们子页面的path——取集合里面的超链接属性
                       String path = aNode.getAttribute("href");
                       //自动添加
                                Page subPage=new Page(
                                        page.getBase(),
                                        path,
                                        true
                                );

                                //把子页面加载到当前页面的主页面了
                       page.getSubPage().add(subPage);
                            }
                    );

                });
    }
}
