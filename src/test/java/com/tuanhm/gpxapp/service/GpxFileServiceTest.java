package com.tuanhm.gpxapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class GpxFileServiceTest {

	@Autowired
	private GpxFileService gpxFileService;

	@Test
	public void upload_should_successful() throws Exception {
		MockMultipartFile multipartFile = new MockMultipartFile("data", "filename.txt", "text/plain",
				"some xml".getBytes());
		gpxFileService.upload(multipartFile);

	}

	@Test
	public void upload_should_haveileEmptyException() throws Exception {
		// TODO implement
	}

	@Test
	public void upload_should_haveFileTypeException() throws Exception {
		// TODO implement
	}

	@Test
	public void upload_should_haveFileTransferException() throws Exception {
		// TODO implement
	}

	@Test
	public void parseFromFile_should_successful() throws Exception {
		// TODO implement
	}

	@Test
	public void parseFromFile_should_haveException() throws Exception {
		// TODO implement
	}

}
