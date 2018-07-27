package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;

	@Autowired
	private CodeUtil codeUtil;

	@Autowired
	private CodecUtil codecUtil;

	@Autowired
	private CommonUtil commonUtil;

	// display reg page
	@RequestMapping("/custReg")
	public String showRegPage() {
		return "RegCustomer";
	}

	// do insert into db
	/***
	 * 1.read data from UI onlcick submit button from Reg page as modelAttribute
	 * 2.generate pwd and tock and decode and set into model object 3.original
	 * values send to email.
	 */
	@RequestMapping(value = "/insertCust", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer cust,
			ModelMap map) {
		// get pwd and tock
		String pwd = codeUtil.getPwd();
		String tock = codeUtil.getTocken();
		// encode them
		String ePwd = codecUtil.doEncode(pwd);
		String eTock = codecUtil.doEncode(tock);
		// set to ModelAttribute
		cust.setCustPwd(ePwd);
		cust.setCustAccTock(eTock);
		// save object
		int custId = service.saveCustomer(cust);
		// send original values to email
		String text = "welcome to customer(" + cust.getCustType() + ")"
				+ "User Name is:" + cust.getCustEmail() + "Password:" + pwd
				+ ",tocken:" + tock + "...all the best";
		// sending email
		commonUtil.sendEmail(cust.getCustEmail(), "welcome to VDM Family..",
				text);
		// send response message to UI
		map.addAttribute("msg", "Registered and Email sent, id:" + custId);
		return "RegCustomer";
	}

}
