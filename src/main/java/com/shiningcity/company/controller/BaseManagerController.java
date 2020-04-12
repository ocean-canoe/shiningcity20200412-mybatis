package com.shiningcity.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiningcity.common.util.SpringContextHolder;
import com.shiningcity.company.service.BaseManagerService;

@RestController
@RequestMapping("/{platform}/manager")
public class BaseManagerController {
	
	private BaseManagerService managerService = SpringContextHolder.getBean(BaseManagerService.class);
	
	@PostMapping("/index")
	public String index(){
		String index = managerService.index(222);
		return "index"+index;
	}
	
	
}
