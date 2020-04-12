package com.shiningcity.company.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
  //存放AsyncContext对象
    public Map<String,AsyncContext> map2 = new HashMap<>();
    @RequestMapping("/aToServer2")
    public void aToServer2(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //将请求转为异步处理
        AsyncContext asyncContext = request.startAsync(request, response);
        //设置超时
        asyncContext.setTimeout(10000);
        //将异步状态保存下来
        map2.put("1", asyncContext);
        //可以监听一些事件
        asyncContext.addListener(new AsyncListener() {
            
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                response.getWriter().write("捕获超时事件");
            }
            
            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
            }
            
            @Override
            public void onError(AsyncEvent event) throws IOException {
            }
            
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("捕获完成事件");
            }
        });
        System.out.println("A请求结束");
    }

    @RequestMapping("/bToServer2")
    public void bToServer2(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //拿到之前的异步状态
        AsyncContext asyncContext = map2.get("1");
        ServletResponse mobileResponse = asyncContext.getResponse();
        mobileResponse.getWriter().write("B响应");
        //记得要手动调用complete,A请求才会结束
        asyncContext.complete();
        System.out.println("B响应结束");
    }
}
