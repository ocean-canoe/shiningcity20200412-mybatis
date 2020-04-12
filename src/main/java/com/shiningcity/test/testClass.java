package com.shiningcity.test;

public class testClass {
	public static void main(String[] args) {
		Integer a = 256;
		Integer b = 256;
		if (a == b) {
			System.out.println("a == b");
		}
		if (a.equals(b)) {
			System.out.println("a equals b");
		}
		Integer c = 2 ;
		Integer d = 1 ;
		Integer e = c-d;
		if (e == d) {
			System.out.println("e == a");
		}
	}
}
