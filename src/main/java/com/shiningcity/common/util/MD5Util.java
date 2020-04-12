package com.shiningcity.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

/*
 * 32为md5加密
 * 如果需要16为则在32位基础上截取索引8-24即可
 */
public class MD5Util {
    
    private static final String MD5 = "MD5";  
    
    // 传统方法
    public static String toMd5StringByJava(String str) throws NoSuchAlgorithmException {
        // 拿到一个MD5转换器
        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        // 转换并返回结果，也是字节数组，包含16个元素
        messageDigest.update(str.getBytes());
        byte[] digest = messageDigest.digest();
        // 字符数组转换成字符串返回 
        //return new HexBinaryAdapter().marshal(digest);
        return byteArrayToHex(digest);
    }
    
    // apache方法 （字母小写）
    public static String toMd5StringByApache(String str) {
        return DigestUtils.md5Hex(str);
    }
    
    /*
     * new HexBinaryAdapter().marshal(digest);和byteArrayToHex方法返回结果一样。
     * new HexBinaryAdapter().marshal(digest);返回结果字母大写，byteArrayToHex返回结果字母大小写可以控制。
     */
    private static String byteArrayToHex(byte[] byteArray) {
        // 首先初始化一个字符数组，用来存放每个16进制字符 
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' }; 
        //char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' }; 
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）） 
        char[] resultCharArray =new char[byteArray.length * 2]; 
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去 
        int index = 0; 
        for (byte b : byteArray) { 
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf]; 
            resultCharArray[index++] = hexDigits[b& 0xf]; 
        }
        // 字符数组组合成字符串返回 
        return new String(resultCharArray);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String md5StringByJava = toMd5StringByJava("hello");
        System.out.println(md5StringByJava);
        String md5StringByApache = toMd5StringByApache("hello");
        System.out.println(md5StringByApache);
        //5D41402ABC4B2A76B9719D911017C592
        //5d41402abc4b2a76b9719d911017c592
    }
}
