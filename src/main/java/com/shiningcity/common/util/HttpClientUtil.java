package com.shiningcity.common.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {
    
    //执行带参数的get请求
    public static String doGet(String url, Map<String, String> headerMap, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            if (null != headerMap) {
                for (String key : headerMap.keySet()) {
                    httpGet.setHeader(key,headerMap.get(key));
                }
            }
            //请求时一定要把token或sessionId放到header带过去
            //httpGet.setHeader("Authorization","Bearer "+token);
            //httpGet.setHeader("Cookie", "JSESSIONID=" + sessionId);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
    //执行不带参数的get请求
    public static String doGet(String url, Map<String, String> headerMap) {
        return doGet(url,headerMap, null);
    }
    
    //执行带参数的post请求
    public static String doPost(String url, Map<String, String> headerMap, Map<String, String> param) {
        
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if (null != headerMap) {
                for (String key : headerMap.keySet()) {
                    httpPost.setHeader(key,headerMap.get(key));
                }
            }
            //请求时一定要把token或sessionId放到header带过去
            //httpGet.setHeader("Authorization","Bearer "+token);
            //httpGet.setHeader("Cookie", "JSESSIONID=" + sessionId);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                    //entity.setContentType("application/json;charset=UTF-8");// 低版本写法
                    entity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");   // 高版本写法
                    entity.setContentEncoding("utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }
    
    //执行不带参数的post请求
    public static String doPost(String url, Map<String, String> headerMap) {
        return doPost(url,headerMap, null);
    }
    
    //执行参数为json的post请求
    public static String doPostJson(String url, Map<String, String> headerMap, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            if (null != headerMap) {
                for (String key : headerMap.keySet()) {
                    httpPost.setHeader(key,headerMap.get(key));
                }
            }
            //请求时一定要把token或sessionId放到header带过去
            //httpGet.setHeader("Authorization","Bearer "+token);
            //httpGet.setHeader("Cookie", "JSESSIONID=" + sessionId);
            // 创建请求内容
            StringEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
            //entity.setContentType("application/json;charset=UTF-8");// 低版本写法
            entity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");   // 高版本写法
                entity.setContentEncoding("utf-8");
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

}
