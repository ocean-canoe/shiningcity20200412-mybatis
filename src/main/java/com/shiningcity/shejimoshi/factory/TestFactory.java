package com.shiningcity.shejimoshi.factory;

import java.util.concurrent.Executors;

public class TestFactory {
	public static void main(String[] args) {

		System.out.println("====私人定制====");
		
        CantingFactory xiansheng = new XianshengCaidan();
        xiansheng.noodle(1).desc();
        xiansheng.drink(2).desc();
        
        CantingFactory meinv = new MeinvCaidan();
        meinv.noodle(2).desc();
        meinv.drink(1).desc();
        
        System.out.println("====批量生产====");
        xiansheng.taocan(1);
        meinv.taocan(2);
        
	}
}
