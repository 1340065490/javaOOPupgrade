package cn.kgc.tangcco.niezhong.commons.properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.kgc.tangcco.niezhong.commons.entity.Bean;

public class PropertiesFactory {

	private static List<Bean> beanList = new ArrayList<>();
	private static Map<String, Object> map = new ConcurrentHashMap<>();
	
}
