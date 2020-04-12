package com.shiningcity.common.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.LinkedHashMap;

public class HttpHelper {
	
	/*
	 * 模拟发送POST请求
	 */
	public static String doPost(String posturl, LinkedHashMap<String, String> headers, String params, String encoding) {
		String resultInfo = null;
		try {
			URL url = new URL(posturl);
			// 调用 openConnection 方法创建连接对象
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 可以根据请求的需要设置参数
			conn.setRequestMethod("POST");
			// 允许向httpUrlConnection中输出内容
			conn.setDoOutput(true);
			// 允许从httpUrlConnection中读入内容
			conn.setDoInput(true);
			// 不允许使用缓存
			conn.setUseCaches(false);
			// 设置请求Headers
			if (null != headers) {
				for (String key : headers.keySet()) {
					conn.setRequestProperty(key, headers.get(key));
				}
			}

			// 连接会话
			conn.connect();
			// 建立输入流，向指向的URL传入参数
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			// 设置请求参数
			dos.write(params.getBytes(encoding));
			dos.flush();
			dos.close();
			// HTTP响应状态码
			int HTTP_Status_Code = conn.getResponseCode();
			// HTTP响应状态的描述性信息
			String HTTP_ResponseMessage = conn.getResponseMessage();
			// 获取HTTP 响应消息获取状态码
			if (conn.getResponseCode() == 200) {

				// 获取响应正文
				BufferedReader reader = null;
				StringBuffer resultBuffer = new StringBuffer();
				String tempLine = null;

				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((tempLine = reader.readLine()) != null) {
					resultBuffer.append(tempLine);
				}
				resultInfo = resultBuffer.toString();
//				System.out.println("- - - - 响应信息：" + resultInfo);
				reader.close();
			} else {
				System.out.println(MessageFormat.format("POST请求失败：HTTP响应码= {0},HTTP响应状态的描述性信息= {1}", HTTP_Status_Code,
						HTTP_ResponseMessage));
			}
		} catch (MalformedURLException e) {
			System.out.println(MessageFormat.format("POST请求时发生异常：{0}", e.getMessage()));
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(MessageFormat.format("POST请求时发生异常：{0}", e.getMessage()));
			e.printStackTrace();
		}
		return resultInfo;
	}
	
	
	

    /*
     * POST请求的头部信息
     */
    public static LinkedHashMap<String, String> getPOSTHeaders(String projectId, String signature, String algorithm,
            String ContentType, String encoding) {
        LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("X-timevale-project-id", projectId);
        headers.put("X-timevale-signature", signature);
        headers.put("X-signature-algorithm", algorithm);
        headers.put("X-timevale-mode", "package");
        headers.put("Content-Type", ContentType);
        headers.put("Charset", encoding);
        return headers;
    }

    /*
     * PUT请求的头部信息
     */
    public static LinkedHashMap<String, String> getPUTHeaders(String ContentMD5, String ContentType, String encoding) {
        LinkedHashMap<String, String> headers = new LinkedHashMap<String, String>();
        headers.put("Content-MD5", ContentMD5);
        headers.put("Content-Type", ContentType);
        headers.put("Charset", encoding);
        return headers;
    }

    /*
     * 向指定URL发送POST方法的请求
     */
    public static String sendPOST(String apiUrl, String data, LinkedHashMap<String, String> headers,
            String encoding) {
        StringBuffer strBuffer = null;
        try {
            // 建立连接
            URL url = new URL(apiUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 需要输出
            httpURLConnection.setDoOutput(true);
            // 需要输入
            httpURLConnection.setDoInput(true);
            // 不允许缓存
            httpURLConnection.setUseCaches(false);

            httpURLConnection.setRequestMethod("POST");
            // 设置Headers
            if (null != headers) {
                for (String key : headers.keySet()) {
                    httpURLConnection.setRequestProperty(key, headers.get(key));
                }
            }

            // 连接会话
            httpURLConnection.connect();
            // 建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
            // 设置请求参数
            dos.write(data.getBytes(encoding));
            dos.flush();
            dos.close();
            // 获得响应状态
            int http_StatusCode = httpURLConnection.getResponseCode();
            String http_ResponseMessage = httpURLConnection.getResponseMessage();
            if (HttpURLConnection.HTTP_OK == http_StatusCode) {
                strBuffer = new StringBuffer();
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    strBuffer.append(readLine);
                }
                responseReader.close();
                // System.out.println("http_StatusCode = " + http_StatusCode + "
                // request_Parameter = " + data);
            } else {
                throw new RuntimeException(
                        MessageFormat.format("请求失败,失败原因: Http状态码 = {0} , {1}", http_StatusCode, http_ResponseMessage));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strBuffer.toString();
    }

    /*
     * 向指定URL发送PUT方法的请求
     */
    public static int sendPUT(String evId, String fileUploadUrl, String filePath,
            LinkedHashMap<String, String> headers) {
        StringBuffer strBuffer = null;
        // 是否上传成功
        int uploadSuccessCode = 0;
        try {
            // 建立连接
            URL url = new URL(fileUploadUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 需要输出
            httpURLConnection.setDoOutput(true);
            // 需要输入
            httpURLConnection.setDoInput(true);
            // 不允许缓存
            httpURLConnection.setUseCaches(false);

            httpURLConnection.setRequestMethod("PUT");
            // 设置Headers
            if (null != headers) {
                for (String key : headers.keySet()) {
                    httpURLConnection.setRequestProperty(key, headers.get(key));
                }
            }
            // 连接会话
            httpURLConnection.connect();
            // 建立输入流，向指向的URL传入参数
            DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
            // 设置请求参数
            dos.write(getBytes(filePath));
            dos.flush();
            dos.close();
            // 获得响应状态
            int http_StatusCode = httpURLConnection.getResponseCode();
            String http_ResponseMessage = httpURLConnection.getResponseMessage();

            if (HttpURLConnection.HTTP_OK == http_StatusCode) {
                strBuffer = new StringBuffer();
                String readLine = new String();
                BufferedReader responseReader = new BufferedReader(
                        new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    strBuffer.append(readLine);
                }
                responseReader.close();
                uploadSuccessCode = http_StatusCode;
                // System.out.println("存证环节编号（证据点编号） = " + evId + "
                // 的待存证文档上传成功！Http状态码 = " + http_StatusCode);
            } else {
                throw new RuntimeException(
                        MessageFormat.format("存证环节编号（证据点编号）= {0} 的待存证文档上传失败,失败信息:Http状态码 = {0} , {1}", http_StatusCode,
                                http_ResponseMessage));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadSuccessCode;
    }
    
    /*
     * 获取文件的Bytes
     */
    public static byte[] getBytes(String filePath) {
        File file = new File(filePath);
        FileInputStream fis = null;
        byte[] buffer = null;
        try {
            fis = new FileInputStream(file);
            buffer = new byte[(int) file.length()];
            fis.read(buffer);
            fis.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("获取文件二进制字节流异常：" + e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("获取文件二进制字节流异常：" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            }
            catch (IOException e) {
                System.out.println("文件二进制字节流关闭时发生异常：" + e.getMessage());
                e.printStackTrace();
            }
        }
        return buffer;
    }
    
    // Demo
//    /***
//     * 定义业务凭证（名称）(如：房屋租赁合同签署)
//     * 
//     * @param businessTempletId
//     *            所属行业类型ID
//     */
//    public static String createSceneType(String apiUrl, String businessTempletId) {
//        System.out.println("请求API接口地址:" + apiUrl);
//        // 数据字典模板ID
//        String templetId = null;
//        // 业务凭证（名称）
//        String sceneBusinessName = "房屋租赁合同签署";
//        // 业务凭证（名称）列表(根据实际情况进行增减或修改,此处仅以"房屋租赁合同签署"为例)
//        ArrayList<String> scenes = new ArrayList<String>();
//        scenes.add(sceneBusinessName);
//
//        // 请求参数-JSON字符串
//        JSONObject param_json = new JSONObject();
//        // businessTempletId对应的是[定义所属行业类型]时获取的[所属行业类型ID]
//        param_json.put("businessTempletId", businessTempletId);
//        param_json.put("name", JSONArray.fromObject(scenes));
//        System.out.println("请求参数:" + param_json);
//
//        // 请求签名值
//        String signature = DigestHelper.getSignature(param_json.toString(), SceneConfig.PROJECT_SECRET,
//                SceneConfig.ALGORITHM, SceneConfig.ENCODING);
//                // System.out.println("请求签署值 = " + signature);
//
//        // HTTP请求内容类型
//        String ContentType = "application/json";
//
//        // 设置HTTP请求头信息
//        LinkedHashMap<String, String> headers = HttpHelper.getPOSTHeaders(SceneConfig.PROJECT_ID, signature,
//                SceneConfig.ALGORITHM, ContentType, SceneConfig.ENCODING);
//        // 向指定URL发送POST方法的请求
//        JSONObject RequestResult = HttpHelper.sendPOST(apiUrl, param_json.toString(), headers, SceneConfig.ENCODING);
//        System.out.println("[定义业务凭证（名称）]接口返回json数据:" + RequestResult);
//        if (0 == RequestResult.getInt("errCode")) {
//            String result = RequestResult.getString("result");
//            templetId = JSONHelper.getTempletId(result, sceneBusinessName);
//        } else {
//            throw new RuntimeException(MessageFormat.format("发生错误,错误信息 = {0}", RequestResult));
//        }
//        return templetId;
//    }
    
}
