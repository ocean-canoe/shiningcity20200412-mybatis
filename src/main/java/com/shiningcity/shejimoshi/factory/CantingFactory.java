package com.shiningcity.shejimoshi.factory;

public interface CantingFactory {
	public Noodle noodle(int type);
	public Drink drink(int type);
	public void taocan(int type);
}
