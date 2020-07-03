package com.tuanhm.gpxapp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService<T> {

	/**
	 * To upload a multipart file
	 * 
	 * @param multipartFile
	 * @throws IOException
	 */
	void upload(MultipartFile multipartFile) throws IOException;

	/**
	 * To parse from a file
	 * 
	 * @param filePath
	 * @return T
	 * @throws IOException
	 */
	T parseFromFile(String filePath) throws IOException;
	
	// TODO: handle multiple files upload
}
