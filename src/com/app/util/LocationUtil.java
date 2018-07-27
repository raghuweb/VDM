package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationUtil {
	@Autowired
	private ILocationService service;

	public List<Location> getAllLocs(){
		return service.getAllLocations();
	}
	
	public void generateAndSavePie(String path,List<Object[]> data){
		//pie data set creation
		
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//preparing chart object..
		JFreeChart chart=ChartFactory.createPieChart3D("Areawise Report", dataset, true, true, false);
		//save chart as image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportALoc.jpg"), chart, 400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void generateAndSaveBar(String path,List<Object[]> data){
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		for(Object[] ob:data){
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "");
		}
		
		JFreeChart chart=ChartFactory.createBarChart3D("Areawise Report", "Location Type", "Location count", dataset);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportBLoc.jpg"), chart, 400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//@Scheduled(fixedDelay=5000)
	public void msg(){
		System.out.println("Hello:"+new Date());
	}
	
	
	
	
}





