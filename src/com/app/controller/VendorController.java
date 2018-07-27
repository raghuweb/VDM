package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private LocationUtil locUtil;
	@Autowired
	private CommonUtil commonUtil;

	// 3 methods
	// show page
	@RequestMapping("/venReg")
	public String showPage(ModelMap map) {
		map.addAttribute("locListObj", locUtil.getAllLocs());
		return "RegVendor";
	}

	// insert data , and send emailm
	@RequestMapping(value = "/insertVen", method = RequestMethod.POST)
	public String insertData(@ModelAttribute("vendor") Vendor ven,
			ModelMap map, @RequestParam("fileinputs") CommonsMultipartFile file) {
		int id = service.saveVendor(ven);
		String resMsg = "Saved succesfully ,with id:" + id;
		// on saving vendor to DB ,also send email
		commonUtil.sendEmail(ven.getVenMail(), "Welcome to VDM..", resMsg, file);//email header, text and file
		// send resMsg to UI also
		map.addAttribute("msg", resMsg);
		return "RegVendor";
	}

	// view all records
	@RequestMapping("/viewAllVen")
	public String showAllRecords(ModelMap map) {
		List<Vendor> venListObj = service.getAllVendors();
		map.addAttribute("venListObj", venListObj);
		return "VendorDataPage";
	}

	@RequestMapping("/deleteVen")
	public String deleteVenRecord(@RequestParam("id") int venId) {
		service.deleteVendorById(venId);

		return "redirect:viewAllVen";
	}

}
