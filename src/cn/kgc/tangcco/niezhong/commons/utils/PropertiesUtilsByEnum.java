package cn.kgc.tangcco.niezhong.commons.utils;

import lombok.Getter;

public enum PropertiesUtilsByEnum {

//	private int num1,num2,num3;
	
	USER("userService","userDao"),
	SUBJECT("subjectService","subjectDao"),
	GRADE("gradeService","gradeDao");
	@Getter
	private String dao,service;
	private PropertiesUtilsByEnum(String service,String dao) {
		this.dao = dao;
		this.service = service;
	}
}
