package com.shiningcity.common.test;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.alibaba.fastjson.JSON;
import com.shiningcity.common.util.SpringContextHolder;

public class TestSpringContextHolder {
    
    public void testGetSpringBean() {
        ThreadPoolTaskExecutor threadPool1 = SpringContextHolder.getBean("threadPool");
        System.out.println("MaxPoolSize="+threadPool1.getMaxPoolSize());
        ThreadPoolTaskExecutor threadPool2 = SpringContextHolder.getBean(ThreadPoolTaskExecutor.class);
        System.out.println("MaxPoolSize="+threadPool2.getMaxPoolSize());
    }
    
}
