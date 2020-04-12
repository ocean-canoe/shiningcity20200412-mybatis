package com.shiningcity.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiningcity.company.service.BaseCompanyServiceImpl;
import com.shiningcity.platform.service.PlatformUserService;

@Controller
@RequestMapping("/{urlParam}/platformUser")
public class PlatformUserController {
	
	@Autowired
	private PlatformUserService userService;
	
	
}
