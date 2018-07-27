package com.app.dao;

import java.util.List;

import com.app.model.UploadFile;

public interface IFileUploadDao {

	public int saveFileObj(UploadFile uf);
	public List<Object[]> getFileIdAndNames();
	public UploadFile getObjById(int fileId);
	
	
	
	
	
	
	
	
}
