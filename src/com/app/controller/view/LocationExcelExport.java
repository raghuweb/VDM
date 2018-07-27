package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocationExcelExport extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		// this is data from DB(location tab)
		List<Location> locList = (List<Location>) map.get("locationListObj");
		// create a sheet to stores rows
		HSSFSheet sheet = book.createSheet("Location");
		// set Header
		setHeader(sheet);
		// set Body
		setBody(sheet, locList);

	}

	private void setHeader(HSSFSheet sheet) {
		HSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("Location Id");
		header.createCell(1).setCellValue("Location Name");
		header.createCell(2).setCellValue("Location Type");

	}

	private void setBody(HSSFSheet sheet, List<Location> locList) {
		int rowNum = 1;
		for (Location loc : locList) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(loc.getLocId());
			row.createCell(1).setCellValue(loc.getLocName());
			row.createCell(2).setCellValue(loc.getLocType());
		}
	}

}
