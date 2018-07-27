package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;

	public int saveCustomer(Customer customer) {
		return (Integer) ht.save(customer);
	}

	public Customer getCustByUserName(String cust) {
		String hql = "from " + Customer.class.getName() + " where custEmail=?";
		List<Customer> list = ht.find(hql, cust);
		if (list == null || list.isEmpty())
			return null;
		else {
			return list.get(0);
		}

	}
}
