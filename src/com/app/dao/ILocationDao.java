package com.app.dao;

import java.util.List;

import com.app.model.Location;

/** POJI -DAL*/
public interface ILocationDao {
	
	public int saveLocation(Location loc);
	/** to get all DB Records*/
	public List<Location> getAllLocations();
	/*** delete records based on Id sent from UI*/
	
	public void deleteLocationById(int locId);
	/** this method is used to get object 
	 * based on primary key value .. id
	 * */
	public Location getLocationById(int locId);
	/***
	 * This method is used for location data 
	 * update into DB.
	 * Complete Object comes from UI
	 * just update into DB using ht.update(obj)
	 */
	public void updateLoc(Location loc);
	/**
	 * Getting data location type wise count
	 * to create charts
	 */
	public List<Object[]> getLocationwiseCount();
	
	
	
	
	
}





