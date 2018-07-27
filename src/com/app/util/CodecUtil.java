package com.app.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CodecUtil {

	
	public String doEncode(String normalStr){
		String encodedStr=null;
		try {
			byte[] arr=Base64.encodeBase64(normalStr.getBytes());
			encodedStr=new String(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodedStr;
	}
	public String doDecode(String encStr){
		String decStr=null;
		try {
			byte[] arr=Base64.decodeBase64(encStr.getBytes());
			decStr=new String(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decStr;
	}
}
