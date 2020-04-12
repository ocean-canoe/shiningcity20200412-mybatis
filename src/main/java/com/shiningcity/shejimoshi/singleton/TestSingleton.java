package com.shiningcity.shejimoshi.singleton;

import java.util.concurrent.Executors;

public class TestSingleton {
	public static void main(String[] args) {
		
		//Calendar并不是单例模式
        //Calendar calendar = Calendar.getInstance();
		
		//懒汉模式
		Singleton aaa = Singleton.getInstance();
        aaa.setIntValue(666);
        Singleton bbb = Singleton.getInstance();
        Integer intValue = bbb.getIntValue();
        System.out.println(intValue);
        
        //饿汉模式
        Singleton2 aaa2 = Singleton2.getInstance();
        aaa2.setIntValue(666);
        Singleton2 bbb2 = Singleton2.getInstance();
        Integer intValue2 = bbb2.getIntValue();
        System.out.println(intValue2);
        
        
        
	}
}
