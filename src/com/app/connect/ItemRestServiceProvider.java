package com.app.connect;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/item")
public class ItemRestServiceProvider {

	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator validator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService itemService;

	@POST
	@Path("/saveItem")
	public String saveItem(
			@HeaderParam("un")String user,
			@HeaderParam("pwd")String password,
			@HeaderParam("tock")String accTock,
			String json){
		String resMsg=null;

		if(user==null || "".equals(user) || password==null
				|| "".equals(password) || accTock==null ||
				"".equals(accTock) || json ==null || "".equals(json)){
			resMsg= "Request data is not complete ";
		}else{		
			//try to load customer obj bsed on input username
			Customer custObj=custService.getCustByUserName(user);
			if(custObj==null){
				resMsg="User Not exist";
			}else{
				//vlidate pwd,acctock
				boolean flag=validator.validateCustomer(password, accTock, custObj);
				if(!flag){
					resMsg="Invalid pwd,tock details";
				}else{
					if(custObj.getCustType().equals("Seller")){
						//do operation 
						Object ob=jsonUtil.convertJsonToObject(json, Item.class);
						if(ob==null){
							resMsg="Invalid data in JSON String";
						}else{
							Item item=(Item)ob;
							item.setCustId(custObj.getCustId());
							int id=itemService.saveItem(item);
							resMsg="Item saved succefully";
						}
					}
					else{
						//reject
						resMsg="Customer type should be seller to perform this operation";
					}
				}
			}
		}
		return resMsg;
	}

	@POST
	@Path("/allItems")
	public String getAllItems(
			@HeaderParam("un")String username,
			@HeaderParam("pwd")String password,
			@HeaderParam("tock")String tock){
		String resMsg=null; 
		//if they are empty or null reject msg
		if(username == null || "".equals(username)
				|| password == null || "".equals(password)	
				|| tock == null || "".equals(tock)){

			resMsg="Request data is not complete";
		}else{
			Customer cust=custService.getCustByUserName(username);
			if(cust==null){
				resMsg="Invalid user name";
			}else{
				//user name exist but check pwd,tock
				boolean flag=validator.validateCustomer(password, tock, cust);
				if(!flag){
					//user is invalid
					resMsg="Invalid pwd,tock..";
				}else{
					//user is valid
					//service.getAllItems
					//jsonutil.convertObjtoJson
					//return json String
				}
			}
		}
		return resMsg;
	}








}


