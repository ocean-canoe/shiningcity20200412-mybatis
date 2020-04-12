package com.shiningcity.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiningcity.platform.mapper.PlatformUserMapper;

@Service
public class PlatformUserService {
	
	@Autowired
	private PlatformUserMapper userMapper;
	
}
