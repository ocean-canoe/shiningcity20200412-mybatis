package com.shiningcity.javaApi.pojo;

import java.math.BigDecimal;

import com.alibaba.fastjson.serializer.BigDecimalCodec;

public class BigDecimalTest {
	
	public static void BigDecimalTest(){
		
		BigDecimal decimal = new BigDecimal(5.6);
		BigDecimal setScale = decimal.setScale(2);
		BigDecimal setScale2 = decimal.setScale(2, BigDecimal.ROUND_UP);
		BigDecimal setScale3 = decimal.setScale(2, BigDecimal.ROUND_DOWN);
		BigDecimal setScale4 = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal setScale5 = decimal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		
		
	}
	
	
}
