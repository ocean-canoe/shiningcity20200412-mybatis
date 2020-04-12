package com.shiningcity.javaApi.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ListTest {
	private static Logger logger = LoggerFactory.getLogger(MapTest.class);
	
	//三种map集合
	public static void ArrayListLinkedListVector() {
		
		//数组转list
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
		
		//ArrayList
		//ArrayList数组结构，插入数据慢，查询数据快，线程不安全，初始容量为0，首次扩容容量为10，每次扩容为原来容量的1.5倍
		List<Object> arrayList = new ArrayList<Object>(10);
		
		//LinkedList
		//LinkedList，采用双向链表结构，插入数据快。线程不安全。
		LinkedList<Object> linkedList = new LinkedList<Object>();
		
		//Vector
		//Vector采用数组结构，插入数据慢，查询数据快，但多线程下有线程锁，线程安全，默认容量为10，每次扩容为原来的2倍，可以指定扩容增量。
		//initialCapacity：初始容量，capacityIncrement：每次扩容增加容量
		Vector<Object> vector = new Vector<Object>(10, 10);
		
		
		
	}
	
	public static void ListBianli() {
		
		List<Object> arrayList = new ArrayList<Object>(10);
		arrayList.add("bcd");
		arrayList.add("def");
		arrayList.add("abc");
		arrayList.add(1, "cde");//在index=1元素前插入新元素。
		//arrayList.add(6, "abcde");
		//arrayList.add(8, "abcdefg");
		//遍历1
		Iterator<Object> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
//			if (next.equals("abc")) {
//				iterator.remove();
//			}
			logger.warn("遍历1：arrayList--{}",next);
		}
		logger.warn("-------------");
		
		//遍历2
		ListIterator<Object> listIterator = arrayList.listIterator();
		while (listIterator.hasNext()) {
			//必须先取索引，后取值，否则索引会错位
			int index = listIterator.nextIndex();
			Object next = listIterator.next();
//			if (next.equals("bcd")) {
//				listIterator.remove();
//				listIterator.add("efg");
//			}
			logger.warn("遍历2：arrayList--{}--{}",index,next);
		}
		while (listIterator.hasPrevious()) {
			//必须先取索引，后取值，否则索引会错位
			int index = listIterator.previousIndex();
			Object previous = listIterator.previous();
			logger.warn("遍历2：arrayList--{}--{}",index,previous);
		}
		logger.warn("-------------");
		
		//遍历5（jdk8，Lambda表达式）
		arrayList.forEach((paval)->logger.warn("遍历5：arrayList--{}",paval));
		
		//
		
	}
	
	public static void main(String[] args) {
		ListBianli();
	}
}
