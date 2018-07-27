package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;
@Service
public class LocationServiceImpl implements ILocationService{
	@Autowired
	private ILocationDao dao;
	
	
	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);
	}
	
	public List<Location> getAllLocations() {
		return dao.getAllLocations();
	}
	
	public void deleteLocationById(int locId) {
		dao.deleteLocationById(locId);
	}
	
	
	public Location getLocationById(int locId) {
		return dao.getLocationById(locId);
	}
	
	public void updateLoc(Location loc) {
		dao.updateLoc(loc);
	}

	
	public List<Object[]> getLocationwiseCount() {
		return dao.getLocationwiseCount();
	}
	
	
}




