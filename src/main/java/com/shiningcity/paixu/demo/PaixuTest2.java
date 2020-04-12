package com.shiningcity.paixu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class PaixuTest2 {
    public static void main(String[] args) {
        
        // 冒泡排序（从小到大）
        System.out.println("冒泡排序（从小到大）");
        int[] arr = new int[]{12,3,24,9,2,1,36,0,7};
        // 从0开始记录遍历次数，第k次遍历数组
        for (int i = 0; i < arr.length-1; i++) {
            // 遍历数组，每次都筛选出大的放到右侧，右边已经筛选好的元素下次不再遍历。
            for (int j = 0; j < arr.length-1-i; j++) {
                // 发现大数字后就往右边替换
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j]+arr[j+1] - (arr[j+1] = arr[j]);
                }
            }
            System.out.println(JSON.toJSON(arr));
        }
        
        System.out.println("---------------------");
        
        // 冒泡排序2（从小到大）实际和上边一个道理
        System.out.println("冒泡排序2（从小到大）");
        int[] arr2 = new int[]{12,3,24,9,2,1,36,0,7};
        // 从第1为元素开始，分别于后边元素比较，遇到小的元素就与当前元素进行交换，
        for (int i = 0; i < arr2.length-1; i++) {
            // 与后边每一个元素比较，
            for (int j = i+1; j <= arr2.length-1; j++) {
                // 遇到小的元素就与当前元素进行交换，
                if (arr2[i] > arr2[j]) {
                    arr2[i] = arr2[i]+arr2[j] - (arr2[j] = arr2[i]);
                }
            }
            System.out.println(JSON.toJSON(arr2));
        }
        
        // 快速排序

        System.out.println("---------------------");
        
        // 公认最快的排序方法（只有从小到大）
        int[] arr3 = new int[]{12,3,24,9,2,1,36,0,7};
        Arrays.sort(arr3);
        System.out.println(JSON.toJSON(arr3));

        System.out.println("---------------------");
        
        // list排序（从小到大）
        List<Integer> list = new ArrayList<Integer>();
        list.add(20);
        list.add(12);
        list.add(36);
        list.add(17);
        list.add(19);
        Collections.sort(list);
        System.out.println(JSON.toJSON(list));
        
        // 如果是单纯的查找最大值或最小值，遍历一遍找出最大值或最小值就好了。
        
    }
}
