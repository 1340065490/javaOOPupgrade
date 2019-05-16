package cn.kgc.tangcco.niezhong.commons.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mysql.jdbc.BufferRow;

import cn.kgc.tangcco.niezhong.commons.entity.Bean;

public class PropertiesFactory {

	private static List<Bean> beanList = new ArrayList<>();
	private static Map<String, Object> map = new ConcurrentHashMap<>();
	static {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/applicationContext.properties"));
			String line = "";
			while((line=reader.readLine())!=null) {
				String split[] = line.split("=");
				Bean bean = new Bean();
				bean.setKey(split[0].trim());
				bean.setValue(split[1].trim());
				beanList.add(bean);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static <T>T getInstance(String key){
		Object obj = null;
		for(Bean bean : beanList) {
			if(key.equals(bean.getKey())) {
				return (T) map.get(key);
			}else {
				String value = bean.getValue();
				try {
					
					obj = Class.forName(value).newInstance();
					map.put(key, obj);
					if(key.endsWith("Service")) {
						Field fields[] = obj.getClass().getDeclaredFields();
						for(Field f : fields) {
							f.setAccessible(true);
							f.set(obj, getInstance(f.getName()));
						}
					}
						
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		return (T) obj;
	}
	
}
