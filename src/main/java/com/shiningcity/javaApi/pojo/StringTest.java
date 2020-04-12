package com.shiningcity.javaApi.pojo;

public class StringTest {
	
	public static void StringTest(){
		
		String str = "abcdefg";
		
		//String拆分成字符数组。
		char[] charArr = str.toCharArray();
		
		//字符串反转（方法一）
		String reverseStr = new StringBuffer(str).reverse().toString();
		
		//字符串反转（方法二）
		char[] charArray = str.toCharArray();
		int i = 0;int j = charArray.length-1;
		char t = '1';//char 定义时用单引号
		while (i<j) {
			t = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = t;
			i++;
			j--;
		}
		String reverseStr2 = new String(charArray);
		
		char charAt = str.charAt(0);
		int length = str.length();
		String substring = str.substring(2, 4);
		String substring2 = str.substring(2);
		CharSequence subSequence = str.subSequence(2, 4);	//CharSequence是String实现的接口
		
		
		
	}
	
}
