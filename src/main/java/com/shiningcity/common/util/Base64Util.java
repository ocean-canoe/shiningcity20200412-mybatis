package com.shiningcity.common.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64Util {
    
    // 传统方法
    public static String encodeByJava(String str) {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        return encoder.encodeToString(str.getBytes());
    }

    // 传统方法2
    public static String encodeBySun(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(str.getBytes());
    }
    
    // apache方法
    public static String encodeByApache(String str) {
        byte[] encodeBase64 = org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes());
        return new String(encodeBase64);
    }
    
    public static String decodeByJava(String str) {
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        byte[] decode = decoder.decode(str);
        return new String(decode);
    }

    public static String decodeBySun(String str) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] decodeBuffer = base64Decoder.decodeBuffer(str);
        return new String(decodeBuffer);
    }
    
    public static String decodeByApache(String str) {
        byte[] decodeBase64 = org.apache.commons.codec.binary.Base64.decodeBase64(str);
        return new String(decodeBase64);
    }
    
    public static void main(String[] args) throws IOException {
        String base64ByJava = encodeByJava("hello");
        String base64BySun = encodeBySun("hello");
        String base64ByApache = encodeByApache("hello");
        System.out.println(base64ByJava);
        System.out.println(base64BySun);
        System.out.println(base64ByApache);
        //aGVsbG8=
        //aGVsbG8=
        //aGVsbG8=
        String decodeByJava = decodeByJava("aGVsbG8=");
        String decodeBySun = decodeBySun("aGVsbG8=");
        String decodeByApache = decodeByApache("aGVsbG8=");
        System.out.println(decodeByJava);
        System.out.println(decodeBySun);
        System.out.println(decodeByApache);
        //hello
        //hello
        //hello
    }
}
