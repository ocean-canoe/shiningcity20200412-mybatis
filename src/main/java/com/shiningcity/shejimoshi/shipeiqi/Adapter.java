package com.shiningcity.shejimoshi.shipeiqi;

//public class Adapter implements Ps2,Usb {
public class Adapter extends Usber implements Ps2,Usb {

	@Override
	public void isPs2() {
		isUsb();
	}

//	@Override
//	public void isUsb() {
//		System.out.println("USB接口。");
//	}
	
}
