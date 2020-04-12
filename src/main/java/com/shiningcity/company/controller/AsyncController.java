package com.shiningcity.company.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
/*
测试SpringMVC的异步请求的处理，
Spring MVC将异步请求细分为了Callable、WebAsyncTask、DeferredResult和ListenableFuture四种类型。
 */
@Controller
public class AsyncController {
    
    @Autowired
    private ThreadPoolTaskExecutor threadPool;
    
    // 返回WebAsyncTask对象。
    @ResponseBody
    @RequestMapping(value = "/webasynctask",produces = "text/plain; charset=UTF-8")
    public WebAsyncTask<String> webAsyncTask(){
        System.out.println("WebAsyncTask处理器主线程进入");
        // 超时时间10秒，使用threadPool线程池，执行Callable中call()方法
        WebAsyncTask<String> task = new WebAsyncTask<String>(10000L,threadPool,new Callable<String>() {
           @Override
            public String call() throws Exception {
                Thread.sleep(5*1000L);
                System.out.println("WebAsyncTask处理执行中。。。");
                return "久等了";
            }
        });
        // WebAsyncTask任务执行完毕后调用方法；
        task.onCompletion(() -> {System.out.println("WebAsyncTask执行完毕。");});
        // WebAsyncTask执行任务超时后调用方法；
        task.onTimeout(() -> {System.out.println("WebAsyncTask超时了");return "WebAsyncTask超时了";});
        System.out.println("WebAsyncTask处理器主线程退出");
        return task;
    }
    
    // 返回Callable对象
    @ResponseBody
    @RequestMapping(value = "/callable",produces = "text/plain; charset=UTF-8")
    public Callable<String> callable(){
        System.out.println("Callable处理器主线程进入");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5 * 1000L);
                System.out.println("Callable处理执行中。。。");
                return "久等了";
            }
        };
        System.out.println("Callable处理器主线程退出");
        return callable;
    }
    
    // 返回DeferredResult
    @ResponseBody
    @RequestMapping(value = "/deferred",produces = "text/plain; charset=UTF-8")
    public DeferredResult<String> deferredResultExam() {
        final DeferredResult<String> result = new DeferredResult<String>(7*1000L, "超时了");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000L);
                    result.setResult("同意 "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return result;
    }
    
    // 返回ListenableFuture
    // 这里处理器的返回值ListenableFuture的泛型是ResponseEntity类型，所以不需要使用@ResponseBody注释也会将返回值直接显示到浏览器。
    @RequestMapping(value = "/listenable",produces = "text/plain; charset=UTF-8")
    public ListenableFuture<ResponseEntity<String>> listenableFuture() {
        ListenableFuture<ResponseEntity<String>> future = new AsyncRestTemplate().getForEntity(
                "http://localhost:8082/shiningcity190201-maven-mybatis/index", String.class);
        System.out.println("listenable请求返回future");
        return future;
    }
    @ResponseBody
    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("正在执行index请求");
        try {
            Thread.sleep(5 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "久等了";
    }
    
    
    
    
}