package cn.kgc.tangcco.niezhong.test.user;


import org.junit.Test;

import cn.kgc.tangcco.niezhong.commons.utils.PropertiesUtilsByEnum;

public class TestUser {

	
	
	@Test
	public void testUser() {
		System.out.println(PropertiesUtilsByEnum.USER.getService());
	}
}
