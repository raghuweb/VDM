package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {

	private String genStr(int length){
		return UUID.randomUUID()
				.toString()
				.replace("-", "")
				.substring(0, length);
	} 
	
	public String getTocken(){
		return genStr(8);
	}
	public String getPwd(){
		return genStr(6);
	}
	
	public String getUserPwd(){
		return genStr(7);
	}
	
	
	
}
