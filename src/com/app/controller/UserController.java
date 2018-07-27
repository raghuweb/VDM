package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//display reg page
	@RequestMapping("/userReg")
	public String showRegpage(){
		return "RegUser";
		
	}
	
	//save user
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user")User user,ModelMap map){
		//generate pwd using codeutil
		String pwd=codeUtil.getUserPwd();
		//set pwd to model object
		user.setPassword(pwd);
		//save into db
		service.saveUser(user);
		//send email using common util
		String text="Welcome to user:"+user.getUserName()
				+" your email id (username):"+user.getUserEmail()
				+" and password : "+user.getPassword();
		commonUtil.sendEmail(user.getUserEmail(), "Registered as User to VDM...", text);
		map.addAttribute("msg", "Registered and mail sent .. id is:"+user.getUserId());
		return "RegUser";
		
	}
	
	//show login page
	@RequestMapping("/loginPage")
    public String showLogin(){
    	return "LoginUser";
    }
	
	//do login
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLoginUser(
	 @RequestParam("un")String un,
	 @RequestParam("pwd")String pwd,ModelMap map,
	 HttpServletRequest req){
		String page=null;
		User user=service.getUserByEmailandPwd(un, pwd);
		if(user==null){
			map.addAttribute("msg", "Login failed...");
			page="LoginUser";
		}else{
			//create session
			HttpSession ses=req.getSession(true);
			ses.setAttribute("username", user.getUserName());
			page="RegLoc";
		}
		return page;
	}
	
	
	//logout process
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest req,ModelMap map){
		//read current session
		HttpSession ses=req.getSession(false);
		//remove attribute value
		ses.setAttribute("username", null);
		//invalidate session
		ses.invalidate();
		//send msg to UI
		map.addAttribute("msg", "Logedout successfully...");
		return "LoginUser";
	}
	
	
	
	
	
}
