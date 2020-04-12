package com.shiningcity.paixu.demo;

import java.util.Comparator;

//符合数组自定义比较器，o1从小到大排序，o1相同时按照o2从小到大排序。
public class MyComprator implements Comparator {
	
	@Override
	public int compare(Object o1, Object o2) {
		Point t1 = (Point) o1;
		Point t2 = (Point) o2;
		if (t1.x!=t2.x) {
			return t1.x>t2.x?1:-1;//-1在前，1在后。
		}else {
			return t1.y>t2.y?1:-1;//-1在前，1在后。
		}
	}
	
}
