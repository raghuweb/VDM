package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private CodecUtil codecUtil;
	
	public boolean validateCustomer(String pwd,String tock,Customer cust){
		
		boolean falg=false;
		//decode pwd and accTcok from DB Object
		String decPwd=codecUtil.doDecode(cust.getCustPwd());
		String decTock=codecUtil.doDecode(cust.getCustAccTock());
		//now compare with input values (header params)
		
		if(pwd.equals(decPwd) && tock.equals(decTock)){
			falg=true;
		}
		
		return falg;
	}
}
