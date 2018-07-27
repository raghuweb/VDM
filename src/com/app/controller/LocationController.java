package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
@Controller
public class LocationController {
	//enable log object
	/*private Log log=LogFactory.getLog(LocationController.class);*/
	
	
	@Autowired
	private ILocationService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private LocationUtil util;
	
	
	/**
	 * Display Reg Page when
	 * /locReg is made from browser
	 */
	@RequestMapping("/locReg")//GET
	public String showLocRegPage(){
		
		//log.info("Request entered into SHOW REG LOC");
		return "RegLoc";
	}
	
	//@RequestMapping("/insertLoc")//GET
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)//POST
	public String saveLocation(@ModelAttribute("location")Location loc,ModelMap map){
		int locId=service.saveLocation(loc);
		map.addAttribute("msg", "Location saved successfully, with id:"+locId);
	//	log.debug("Data saved with id:"+locId);
		return "RegLoc";
	}
	
	
	/**
	 * this method is used to get
	 * all records from DB using
	 * service and send to UI
	 * using modelMap
	 */
	@RequestMapping("/viewAllLoc")
	public String getAllRecords(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locListObj", locList);
		return "LocDataPage";
	}
	
	/**
	 * This method will be 
	 * called from UI , when
	 * user click on delete link
	 * ?id=__ value is given to
	 * this method, it call service
	 * to delete record.
	 * Once delete is done redirect to
	 * viewAllLoc to get all records
	 * and display.
	 */
	@RequestMapping("/deleteLoc")
	public String deleteLocRecord(@RequestParam("id")int locId){
	 /*** use service to call service layer method (delete method**/
		service.deleteLocationById(locId);
		/*** then re-direct to viewAllLoc*/
		/** below one equals to 
		 * response.sendRedirect(...);
		 */
		return "redirect:viewAllLoc";
	}
	
	/***
	 * Show Edit Page
	 * when request comes from Data 
	 * page, also read id and send it to
	 * service to get related data from
	 * DB, and send data to Edit Page
	 * using ModelMap.
	 */
	@RequestMapping("/editLoc")
	public String showEditPage(@RequestParam("id")int locId,
			ModelMap map){
		Location loc=service.getLocationById(locId);
		map.addAttribute("locObj", loc);
		return "LocDataEditPage";
	}
	
	/***
	 * This method reads data from UI Form
	 * as ModelAttribute and send this data to
	 * service to update in DB
	 * and return back to view All records
	 * Method should be post type
	 */
	@RequestMapping(value="updateLoc",method=RequestMethod.POST)
	public String updateLoc(@ModelAttribute("location")Location loc){
		service.updateLoc(loc);
		return "redirect:viewAllLoc";
	}
	
	/**
	 * To export data to excel format
	 * this controller will be called
	 * when we click on <a> tag from JSP
	 */
	@RequestMapping("/locExcelExport")
	public String locExportExcelFormat(ModelMap map){
		map.addAttribute("locationListObj",service.getAllLocations());
		return "LocationExcelFormat";
	}
	
	@RequestMapping("/locPdfExport")
	public String locExportPdfFormat(ModelMap map){
		map.addAttribute("locationListObj",service.getAllLocations());
		return "LocationPdfFormat";
	}
	
	/**
	 * This method is designed for report generation
	 * of locations
	 */
	@RequestMapping("/showReport")
	public String generateReport(){
		String path=context.getRealPath("/");
		List<Object[]> data=service.getLocationwiseCount();
		util.generateAndSavePie(path, data);
		util.generateAndSaveBar(path, data);
		return "ReportPage";
	}
}




