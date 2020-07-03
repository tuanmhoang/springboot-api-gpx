package com.tuanhm.gpxapp.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.tuanhm.gpxapp.common.Constant;
import com.tuanhm.gpxapp.dao.GpsDao;
import com.tuanhm.gpxapp.entity.GPS;
import com.tuanhm.gpxapp.exception.GpsFileException;

import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Metadata;
import io.jenetics.jpx.Route;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.WayPoint;

/**
 * @author Tuan
 *
 */
@Service
public class GpxFileService implements FileService<GPS> {

	private static final String UPLOADED_RESOURCES_FOLDER = "uploaded-resources";

	@Autowired
	private GpsDao gpsDao;

	// TODO: handle multiple files upload
	@Override
	public void upload(MultipartFile multipartFile) throws IOException {
		// verify if the file is empty
		if (multipartFile.isEmpty())
			throw new GpsFileException("File is empty! Please send a file.");
		String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

		// verify file extension
		if (!Arrays.stream(Constant.VALID_FILE_EXTENSIONS).anyMatch(extension.toLowerCase()::equals))
			throw new GpsFileException(
					"File extension is incorrect! Allowed extension is: " + Constant.VALID_FILE_EXTENSIONS.toString());

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String fileName = timestamp.toString().replace(":", "-") + multipartFile.getOriginalFilename();

		File file = new File(this.getClass().getClassLoader().getResource(UPLOADED_RESOURCES_FOLDER).getPath(),
				fileName);
		multipartFile.transferTo(file);

		// save uploaded file to upload directory
		GPS gps = parseFromFile(file.getAbsolutePath());
		gpsDao.save(gps);
	}

	@Override
	public GPS parseFromFile(String filePath) throws IOException {
		GPX gpx = GPX.read(filePath);
		GPS gps = new GPS();
		Gson gson = new Gson();

		// parse metadata
		Metadata metadata = gpx.getMetadata().get();
		gps.setMetadata(gson.toJson(metadata));

		// parse metadata time
		ZonedDateTime zonedDateTime = metadata.getTime().get();
		Date date = Date.from(zonedDateTime.toInstant());
		gps.setMetadataTime(date);

		// parse waypoints
		List<WayPoint> wayPoints = gpx.getWayPoints();
		gps.setWaypoints(gson.toJson(wayPoints));

		// parse routes
		List<Route> routes = gpx.getRoutes();
		gps.setRoutes(gson.toJson(routes));

		// parse tracks
		List<Track> tracks = gpx.getTracks();
		gps.setTracks(gson.toJson(tracks));

		// set uploaded time
		gps.setUploadedTime(new Date());

		return gps;
	}

}
