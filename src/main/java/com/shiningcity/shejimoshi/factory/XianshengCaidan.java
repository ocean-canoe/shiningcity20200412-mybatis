package com.shiningcity.shejimoshi.factory;

public class XianshengCaidan implements CantingFactory {

	private Integer TYPE_NUMBER1 = 1;
	private Integer TYPE_NUMBER2 = 2;
	
	@Override
	public Noodle noodle(int type) {
		if (type==TYPE_NUMBER1) {
			return new LanzhouNoodle();
		}else if (type==TYPE_NUMBER2) {
			return new ZhengzhouNoodle();
		}
		return null;
	}

	@Override
	public Drink drink(int type) {
		if (type==TYPE_NUMBER1) {
			return new WaterDrink();
		}else if (type==TYPE_NUMBER2) {
			return new TeaDrink();
		}
		return null;
	}
	
	@Override
	public void taocan(int type){
		noodle(type).desc();
		drink(type).desc();
	}
	
}
