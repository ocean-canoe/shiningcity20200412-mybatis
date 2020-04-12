package com.shiningcity.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiningcity.platform.mapper.PlatformRoleMapper;

@Service
public class PlatformRoleService {
	
	@Autowired
	private PlatformRoleMapper roleMapper;
	
}
