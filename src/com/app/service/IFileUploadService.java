package com.app.service;

import java.util.List;

import com.app.model.UploadFile;

public interface IFileUploadService {

	public int saveFileObj(UploadFile uf);
	public List<Object[]> getFileIdAndNames();
	public UploadFile getObjById(int fileId);
}






