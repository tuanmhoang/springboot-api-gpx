package com.tuanhm.gpxapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tuanhm.gpxapp.dto.TrackDetailsDto;
import com.tuanhm.gpxapp.dto.TrackDto;
import com.tuanhm.gpxapp.service.GpxFileService;
import com.tuanhm.gpxapp.service.GpxTracksService;

/**
 * Controller for gps app
 * @author Tuan
 *
 */
@RestController
@RequestMapping("/gps")
public class GpsController {

	@Autowired
	private GpxFileService gpxFileService;
	
	@Autowired
	private GpxTracksService gpxTracksService;

	@PostMapping(value = "/upload")
	public String upload(@RequestParam("file") MultipartFile multipartFile) {
		try {
			gpxFileService.upload(multipartFile);
		} catch (IOException e) {
			return e.getMessage();
		}
		return "successful";
	}
	
	@PostMapping(value = "/latest")
	public List<TrackDto> getLatestTracks() {
		return gpxTracksService.getLatestTracks();
	}
	
	
	@GetMapping(value ="/details/{id}")
	public TrackDetailsDto getTrackDetails(@PathVariable int id) {
		try {
			return gpxTracksService.viewDetails(id);
		} catch (IOException e) {
			e.printStackTrace();
			return new TrackDetailsDto();
		}
	}
}
