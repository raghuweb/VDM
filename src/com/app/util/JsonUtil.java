package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

	public Object convertJsonToObject(String json,Class cls){
		Object ob=null;
		try {
			ob=new ObjectMapper()
			.readValue(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	
	public String convertObjectToJson(Object ob){
		String str=null;
		try {
			str=new ObjectMapper()
			.writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	
	
}
