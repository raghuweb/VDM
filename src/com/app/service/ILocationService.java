package com.app.service;

import java.util.List;

import com.app.model.Location;

public interface ILocationService {
	/***copy all methods from I__Dao**/
	public int saveLocation(Location loc);
	public List<Location> getAllLocations();
	public void deleteLocationById(int locId);
	public Location getLocationById(int locId);
	public void updateLoc(Location loc);
	public List<Object[]> getLocationwiseCount();
	
	
	
	
	
	
	
}
