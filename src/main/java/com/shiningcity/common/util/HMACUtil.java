package com.shiningcity.common.util;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
 
//@SuppressWarnings("restriction")
public class HMACUtil {
    
    private static final String HMAC_MD5 = "HmacMD5";
    private static final String HMAC_SHA1 = "HmacSHA1";  
    private static final String HMAC_SHA256 = "HmacSHA256";  
    private static final String HMAC_SHA384 = "HmacSHA384";  
    private static final String HMAC_SHA512 = "HmacSHA512";  

//    //Hmac加密
//    // 此方法不可取，加密结果每次都不一样。
//    public static String toHmacMD5(String str) throws Exception {
//        // 初始化HMAC密钥
//        KeyGenerator keyGenerator = KeyGenerator.getInstance(HMAC_MD5);
//        SecretKey secretKey = keyGenerator.generateKey();
//        String key = new BASE64Encoder().encodeBuffer(secretKey.getEncoded());
//        //sun.misc.BASE64Decoder;
//        //sun.misc.BASE64Encoder;
//        //HMAC加密
//        SecretKey secretKey2 = new SecretKeySpec(new BASE64Decoder().decodeBuffer(key), HMAC_MD5);
//        Mac mac = Mac.getInstance(secretKey2.getAlgorithm());
//        mac.init(secretKey2);
//        //return new BigInteger(mac.doFinal(str.getBytes())).toString();
//        return new HexBinaryAdapter().marshal(mac.doFinal(str.getBytes()));
//    }
    
    /*
     * HmacMD5加密
     * @param data 待加密的数据  
     * @param key  加密使用的key  
     */
    public static String toHmacMD5(String data,String key) throws Exception {
        return toHmac(data, key, HMAC_MD5);
    }

    /*
     * HmacSHA1加密
     * @param data 待加密的数据  
     * @param key  加密使用的key  
     */
    public static String toHmacSHA1(String data,String key) throws Exception {
        return toHmac(data, key, HMAC_SHA1);
    }

    /*
     * HmacSHA256加密
     * @param data 待加密的数据  
     * @param key  加密使用的key  
     */
    public static String toHmacSHA256(String data,String key) throws Exception {
        return toHmac(data, key, HMAC_SHA256);
    }

    /*
     * HmacSHA384加密
     * @param data 待加密的数据  
     * @param key  加密使用的key  
     */
    public static String toHmacSHA384(String data,String key) throws Exception {
        return toHmac(data, key, HMAC_SHA384);
    }
    
    /*
     * HmacSHA512加密
     * @param data 待加密的数据  
     * @param key  加密使用的key  
     */
    public static String toHmacSHA512(String data,String key) throws Exception {
        return toHmac(data, key, HMAC_SHA512);
    }
    
    /*
     * 生成签名数据  
     * @param data 待加密的数据  
     * @param key  加密使用的key  
     */
    private static String toHmac(String data,String key,String keyMac) throws Exception{
        byte[] keyBytes=key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, keyMac);   
        Mac mac = Mac.getInstance(keyMac);   
        mac.init(signingKey);   
        byte[] rawHmac = mac.doFinal(data.getBytes());
        //return byteArrayToHex(rawHmac);
        return new HexBinaryAdapter().marshal(rawHmac);
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
    
    public static void main(String[] args) throws Exception{
        String hmacMD5 = toHmacMD5("hello","hello");
        String hmacSHA1 = toHmacSHA1("hello","hello");
        String hmacSHA256 = toHmacSHA256("hello","hello");
        String hmacSHA384 = toHmacSHA384("hello","hello");
        String hmacSHA512 = toHmacSHA512("hello","hello");
        
        System.out.println(hmacMD5);
        System.out.println(hmacSHA1);
        System.out.println(hmacSHA256);
        System.out.println(hmacSHA384);
        System.out.println(hmacSHA512);
//A092156BE8E7A5C59E88705F06C05904
//9ADE18F3E0EE81A5343F4A005F795DBAF9CEEFD8
//B270147FF516860AAFB4F52818CB149DEFDE2FAC57B451FA3B053D24E88B915A
//68E762D45E27EFA2BF110729FFE97E95BE01B53BF23EBDB3DD70EE1EB6BC09D2A888BD1B2476B12A5270269E508F0A3C
//8F9909C45E601A31A2E6949FE6E4C739ADE74F3A0A5F9489D4E5F8BC5B71C08C998C78E14AB4C524E884A308E1E4B9902E7E76D9E1328E5A603B7DFA42604D74
    }
    
}
