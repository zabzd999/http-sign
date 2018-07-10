package com.github.wxiaoqi.security.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Hello world!
 *
 */
@Component
public class App 
{
    @Autowired
    HttpServletRequest request;

    public  String getSign(String str ) throws FailingHttpStatusCodeException, MalformedURLException, IOException
    {
    	  WebClient webClient = new WebClient();
          webClient.getOptions().setJavaScriptEnabled(true);
          webClient.getOptions().setCssEnabled(false);
          webClient.getOptions().setUseInsecureSSL(false);
//          webClient.getOptions().setTimeout(3000);
   
   
          //获取页面
          String url ="http://127.0.0.1:8762/sign?sign="+str;
          HtmlPage page = webClient.getPage(url);
   
//          System.out.println("页面文本:"+page.getTitleText());
   
   
          //获取页面元素
  
   
        HtmlInput btn = page.getHtmlElementById("click");
//          HtmlPage page2 = btn.click();
        DomElement  dd= page.getElementById("sign");
        DomElement  dd2= page.getElementById("signStr");

//          System.out.println("======="+dd.getTextContent());;
        System.out.println("======="+dd2.asText());;
//          System.out.println("页面2:"+page2.getTitleText());

        return dd.asText();

    }
}
