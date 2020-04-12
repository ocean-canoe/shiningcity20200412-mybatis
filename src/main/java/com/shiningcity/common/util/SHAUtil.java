package com.shiningcity.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/*
一、概述
SHA算法基于MD4算法基础之上，作为MD算法的继任者，成为新一代消息摘要算法的代表。SHA与MD算法不同之处主要在于摘要长度，SHA算法的摘要长度更长，安全性更高。
SHA（Secure Hash Algorithm，安全散列算法）是消息摘要算法的一种，被广泛认可的MD5算法的继任者。SHA算法家族目前共有SHA-0、SHA-1、SHA-224、SHA-256、SHA-384和SHA-512五种算法，通常将后四种算法并称为SHA-2算法。
SHA算法发展：
SHA-0算法：
SHA-0是在1993年发布的，但由于最后发现SHA-0算法中含有会降低密码安全性的错误被收回。
SHA-1算法：
1995年，发布了SHA-1算法，通常我们把SHA-1算法简称为SHA算法。SHA-1算法在许多安全协定中广为使用，包括TLS/SSL、PGP、SSH、S/MIME和IPsec，曾被视为是MD5算法的后继者。SHA-0和SHA-1算法可对最大长度为264的字节信息做摘要处理，得到一个160的摘要信息，其设计原理相似于MD4和MD5算法。如果将得到160位的摘要信息换算成十六进制，可以得到一个40位的字符串。
SHA-2算法：
SHA算法家族除了其代表SHA-1算法以外，还有SHA-224、SHA-256、SHA-384和SHA-512四种SHA算法的变体，以其摘要信息字节长度不同而命名，通常将这组算法并称为SHA-2算法。摘要信息字节长度的差异是SHA-2和SHA-1算法的最大差异。
 */
/*
在java6中。MessageDigest类支持MD算法的同时也支持SHA算法，几乎涵盖了我们所知的全部SHA系列算法，主要包含SHA-1、SHA-256、SHA-384、SHA-512四种算法。
注：SHA是用于数字签名，没有解密函数，前台和后台只能通过对比加密后的密文是否一致进行判断。
 */
public class SHAUtil {
    
    private static final String SHA1 = "SHA";  
    private static final String SHA256 = "SHA-256";  
    private static final String SHA384 = "SHA-384";  
    private static final String SHA512 = "SHA-512";  

    // SHA-1消息摘要算法
    public static String toSHA1(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA1);
        //messageDigest.update(str.getBytes());
        //byte[] digest = messageDigest.digest();
        byte[] digest = messageDigest.digest(str.getBytes());
        //return new BigInteger(digest).toString(); // 此方法不可取
        //return byteArrayToHex(digest);
        return new HexBinaryAdapter().marshal(digest);
    }
    
    // SHA-256消息摘要算法
    public static String toSHA256(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA256);
        byte[] digest = messageDigest.digest(str.getBytes());
        //return byteArrayToHex(digest);
        return new HexBinaryAdapter().marshal(digest);
    }
    
    // SHA-384消息摘要算法
    public static String toSHA384(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA384);
        byte[] digest = messageDigest.digest(str.getBytes());
        //return byteArrayToHex(digest);
        return new HexBinaryAdapter().marshal(digest);
    }

    // SHA-512消息摘要算法
    public static String toSHA512(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(SHA512);
        byte[] digest = messageDigest.digest(str.getBytes());
        //return byteArrayToHex(digest);
        return new HexBinaryAdapter().marshal(digest);
    }
    
    /*
     * new HexBinaryAdapter().marshal(digest);和byteArrayToHex方法返回结果一样。
     * new HexBinaryAdapter().marshal(digest);返回结果字母大写，byteArrayToHex返回结果字母大小写可以控制。
     */
    private static String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' }; 
        //char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' }; 
        char[] resultCharArray =new char[byteArray.length * 2]; 
        int index = 0; 
        for (byte b : byteArray) { 
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf]; 
            resultCharArray[index++] = hexDigits[b& 0xf]; 
        }
        return new String(resultCharArray);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String sha1 = toSHA1("hello");
        String sha256 = toSHA256("hello");
        String sha384 = toSHA384("hello");
        String sha512 = toSHA512("hello");
        System.out.println(sha1);
        System.out.println(sha256);
        System.out.println(sha384);
        System.out.println(sha512);
//AAF4C61DDCC5E8A2DABEDE0F3B482CD9AEA9434D
//2CF24DBA5FB0A30E26E83B2AC5B9E29E1B161E5C1FA7425E73043362938B9824
//59E1748777448C69DE6B800D7A33BBFB9FF1B463E44354C3553BCDB9C666FA90125A3C79F90397BDF5F6A13DE828684F
//9B71D224BD62F3785D96D46AD3EA3D73319BFBC2890CAADAE2DFF72519673CA72323C3D99BA5C11D7C7ACC6E14B8C5DA0C4663475C2E5C3ADEF46F73BCDEC043
    }
}
