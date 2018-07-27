package com.app.dao;

import com.app.model.Customer;

public interface ICustomerDao {

	public int saveCustomer(Customer customer);
	public Customer getCustByUserName(String cust);
	
}
