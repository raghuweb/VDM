package com.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.UploadFile;
import com.app.service.IFileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private IFileUploadService service;
	/**
	 * This is to display File Upload
	 * Page
	 */
	@RequestMapping("/showUpload")
	public String showPage(ModelMap map){
		map.addAttribute("fileListData", service.getFileIdAndNames());
		return "FileUploadPage";
	}
	/**
	 * This method is used to read 
	 * file,id from UI and save into
	 * DB using UploadFile Model class
	 * @param fileId
	 * @param cmFile
	 * @return
	 */
	@RequestMapping(value="/insertFile",method=RequestMethod.POST)
	public String insertFileObj(
			@RequestParam("fid")int fileId,			
			@RequestParam("fileObjss")CommonsMultipartFile cmFile			
			){
		if(cmFile!=null){
			//converting inputs to model class obj
			UploadFile uf=new UploadFile();
			uf.setFileId(fileId);
			System.out.println("File name:"+cmFile.getOriginalFilename());
			uf.setFileName(cmFile.getOriginalFilename());
			uf.setFileData(cmFile.getBytes());
			service.saveFileObj(uf);
		}

		return "redirect:showUpload";
	}


	
	@RequestMapping("/fileDownload")
	public void downloadFileObj(HttpServletResponse res,
			@RequestParam("id")int fileId){
		try {
			UploadFile file=service.getObjById(fileId);
			res.addHeader("Content-Disposition", "attachment;filename="+file.getFileName());
			FileCopyUtils.copy(file.getFileData(), res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	




}
