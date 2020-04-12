package com.shiningcity.shejimoshi.factory;

public class MeinvCaidan implements CantingFactory {

	private Integer TYPE_NUMBER1 = 1;
	private Integer TYPE_NUMBER2 = 2;
	
	@Override
	public Noodle noodle(int type) {
		if (type==TYPE_NUMBER1) {
			return new MixianNoodle();
		}else if (type==TYPE_NUMBER2) {
			return new TudoufenNoodle();
		}
		return null;
	}

	@Override
	public Drink drink(int type) {
		if (type==TYPE_NUMBER1) {
			return new ChengzhiDrink();
		}else if (type==TYPE_NUMBER2) {
			return new XuebiDrink();
		}
		return null;
	}
	
	@Override
	public void taocan(int type){
		noodle(type).desc();
		drink(type).desc();
	}

}
