package com.shiningcity.shejimoshi.singleton;

//饿汉模式。推荐使用饿汉模式。
public class Singleton2 {
	
	private Integer intValue;
	// 提供一个私有的属性存放类的对象。
	private static Singleton2 instance = new Singleton2();
	// 构造函数私有化。
	private Singleton2(){}
	// 提供一个公有方法获取类的对象。
	public static Singleton2 getInstance(){
		return instance;
	}

	public Integer getIntValue() {
		return intValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}
	
	
}
