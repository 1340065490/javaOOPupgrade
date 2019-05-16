package cn.kgc.tangcco.niezhong.commons.utils;

import lombok.Getter;

public class PropertiesUtil {
	@Getter
	private String dao,service;

	private PropertiesUtil(String dao, String service) {
		this.dao = dao;
		this.service = service;
	}
	
	public static final PropertiesUtil USER = new PropertiesUtil("userDao", "userService");
	
	
	
}
