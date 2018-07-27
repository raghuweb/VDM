package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IFileUploadDao;
import com.app.model.UploadFile;
import com.app.service.IFileUploadService;

@Service
public class FileUploadServiceImpl implements IFileUploadService{
	@Autowired
	private IFileUploadDao dao;
	
	
	public int saveFileObj(UploadFile uf) {
		return dao.saveFileObj(uf);
	}
	
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}
	
	public UploadFile getObjById(int fileId) {
		return dao.getObjById(fileId);
	}
	
	
	
	
	
	
	
	
}





