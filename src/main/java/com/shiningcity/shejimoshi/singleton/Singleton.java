package com.shiningcity.shejimoshi.singleton;

//懒汉模式
//如果没有synchronized则线程不安全，但如果加上synchronized，其实大部分情况下不需要加锁。所以推荐使用饿汉模式。
public class Singleton {
	
	private Integer intValue;
	
	private static Singleton instance;
	// 
	private Singleton(){}
	
	public static synchronized Singleton getInstance(){
		if (instance==null) {
			instance = new Singleton();
		}
		return instance;
	}

	public Integer getIntValue() {
		return intValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}
	
	
}
