package com.wschase.tangpoerty;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**模拟浏览器
 * Author:WSChase
 * Created:2019/3/28
 */
public class TestHtmlUnit {

    public static void main(String[] args) {
        try(WebClient webClient=new WebClient(BrowserVersion.CHROME)){
            try {

               //1.数据的采集
                webClient.getOptions().setJavaScriptEnabled(false);
               HtmlPage htmlPage = webClient.getPage("https://www.gushiwen.org/");

//               HtmlElement bodyElement = htmlPage.getBody();
//               //asTxt取出来的只是文本
//               String txt = bodyElement.asText();
//                System.out.println(txt);
//
////                //asXml取出来的只是文本
////                String txt = bodyElement.asXml();

                //2.数据的解析
                HtmlDivision domElement = (HtmlDivision) htmlPage.getElementById("contsona51c59087fc8");
                String divContent=domElement.asText();
                System.out.println(divContent);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
