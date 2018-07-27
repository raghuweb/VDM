package com.app.service;

import com.app.model.Customer;

public interface ICustomerService {

	public int saveCustomer(Customer customer);
	public Customer getCustByUserName(String cust);
}
