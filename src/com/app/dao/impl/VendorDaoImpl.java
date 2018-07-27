package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private HibernateTemplate ht;

	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

	public int saveVendor(Vendor ven) {
		return (Integer) ht.save(ven);
	}

	public void deleteVendorById(int venId) {
		ht.delete(new Vendor(venId));
	}

}
