package com.shiningcity.company.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shiningcity.company.service.BaseCompanyService;



@RestController
@RequestMapping("/file")
public class FileController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	private BaseCompanyService companyBaService;
	
	@PostMapping("/filePage")
	public String filePage(){
		return "fileUpload";
	}
	
	//单文件上传
	@PostMapping("/fileUploadSingle")
	public Map<Object, Object> fileUploadSingle(MultipartFile multipartFile,String folderName,HttpServletRequest request){
		Map<Object, Object> map = new HashMap<>();
		if(multipartFile!=null){
			try {
				//文件上传保存路径（硬盘路径）
				String path = request.getSession().getServletContext().getRealPath("//");
				//获得图片的原始名称（不含路径）
				String origanlFileName = multipartFile.getOriginalFilename();
				
				//上传图片的保存的新名称，随机字符串+。jpg
				Date date = new Date();
				String newFileName = dateTimeFormat.format(date)+origanlFileName.substring(origanlFileName.lastIndexOf("."));
				String webPath = "";
				if (folderName!=null&&!folderName.isEmpty()) {
					webPath = "/update/"+folderName+"/"+dateFormat.format(date)+"/"+newFileName;
				}else {
					webPath = "/update/"+dateFormat.format(date)+"/"+newFileName;
				}
				
				File file = new File(path+webPath);
				if(file.getParent()!=null && !new File(file.getParent()).exists()){
				    new File(file.getParent()).mkdirs();
				}
				multipartFile.transferTo(file);
				
				map.put("success", true);
				map.put("fileName", newFileName);
				map.put("fileType", newFileName.substring(newFileName.lastIndexOf(".")));
				map.put("webPath", webPath);
			} catch (IllegalStateException | IOException e) {
				//e.printStackTrace();
				logger.error("{}",e);
				map.put("success", false);
			}
		}
		return map;
	}
	
	//多文件上传
	@PostMapping("/fileUploadMore")
	public List<Map<Object, Object>> fileUploadMore(MultipartFile[] fileArr,String folderName,HttpServletRequest request) {
		List<Map<Object, Object>> list = new ArrayList<>();
		for(MultipartFile multipartFile:fileArr){
			Map<Object, Object> map = fileUploadSingle(multipartFile, folderName, request);
			list.add(map);
		}
		return list;
	}
	
	//下载 
	@PostMapping("/fileDownload")
	public void fileDownload(String webPath,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String path = request.getSession().getServletContext().getRealPath("//");
		String filePath = path+webPath;
		String filename = webPath.substring(webPath.lastIndexOf("/"));
		//filename = URLDecoder.decode(filename,"UTF-8");
		//filename = new String(filename.getBytes("iso-8859-1"),"UTF-8");//get提交，修改编码
		//filename = URLEncoder.encode(filename,"UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-dispsition", "attachment;filname="+filename);
		//response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gbk"), "iso8859-1"));  
		File file = new File(filePath);
		response.setContentLength((int)file.length());
		
		int len = 0;
		byte[] buffer = new byte[8192];
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();
		while((len = fis.read(buffer))!=-1){
			sos.write(buffer,0,len);
		}
		sos.close();
		fis.close();
	}
	
	@PostMapping(value="/inputStream")
	public String inputStream(){
		
		String result = companyBaService.inputStream();
		
		return result;
	}
}
