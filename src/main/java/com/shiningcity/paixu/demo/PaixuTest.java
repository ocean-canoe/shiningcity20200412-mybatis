package com.shiningcity.paixu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;

import com.alibaba.fastjson.JSON;

public class PaixuTest {
	public static void main(String[] args) {

        int[] arr = new int[]{12,3,24,9,2,1,36,0,7};
        //使用Arrays.sort()进行排序，Arrays.sort()是“经过调优的快速排序法”
        Arrays.sort(arr);
        System.out.println(JSON.toJSON(arr));
        int i = Arrays.binarySearch(arr, 0);
        System.out.println(i);
        
        //Arrays.sort()默认升序，不提供降序排序，可以升序排序完毕后再自己降序。
        int t ;
        int in = arr.length-1;
        for (int j = 0; j < arr.length/2; j++) {
			t = arr[j];
			arr[j] = arr[in-j];
			arr[in-j] = t;
		}
        System.out.println(JSON.toJSON(arr));
        
        //二维数组。
        int[][] arr3 = {{2,5},{1},{3,2,4},{1,7,5,9}};
        System.out.println("arr3[0]="+arr3[0]);
        System.out.println("arr3[0][0]="+arr3[0][0]);
        
        //list排序。
        List<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(12);
        list.add(36);
        list.add(17);
        list.add(19);
        Collections.sort(list);
        System.out.println(JSON.toJSON(list));
        
        //键盘输入。
//      Scanner scanner = new Scanner(System.in);
//      list.add(scanner.nextInt());
//      list.add(scanner.nextInt());
//      list.add(scanner.nextInt());
//      list.add(scanner.nextInt());
//      list.add(scanner.nextInt());
        
        //集合与数组转换
//        Object[] array = list.toArray();
//        Arrays.sort(array);
//        List<Object> asList = Arrays.asList(array);
        
        //对复合数据类型的数组进行排序。
        Point[] arr4 = new Point[4];
        arr4[0]=new Point(2, 1);
        arr4[1]=new Point(2, 2);
        arr4[2]=new Point(1, 2);
        arr4[3]=new Point(1, 1);
        System.out.println(JSON.toJSON(arr4));
        Arrays.sort(arr4, new MyComprator());
        System.out.println(JSON.toJSON(arr4));
        
        Map<Integer, Object> map = new HashMap<Integer, Object>(16);
        Map<Integer, Object> synchronizedHashMap = Collections.synchronizedMap(map);//使map集合编程线程安全的集合。
        //或者如下：
        Map<Integer,Object> synchronizedHashMap2 = Collections.synchronizedMap(new HashMap<Integer,Object>(16));
	
	}
}
