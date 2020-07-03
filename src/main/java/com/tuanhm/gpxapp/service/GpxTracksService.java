package com.tuanhm.gpxapp.service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tuanhm.gpxapp.customconfig.GsonUtcDateAdapter;
import com.tuanhm.gpxapp.dao.GpsDao;
import com.tuanhm.gpxapp.dao.GpsDaoCustom;
import com.tuanhm.gpxapp.dto.TrackDetailsDto;
import com.tuanhm.gpxapp.dto.TrackDto;
import com.tuanhm.gpxapp.dto.WaypointDto;
import com.tuanhm.gpxapp.entity.GPS;

import io.jenetics.jpx.Metadata;
import io.jenetics.jpx.WayPoint;

@Service
public class GpxTracksService implements TracksService {

	@Autowired
	private GpsDaoCustom gpsDaoCustom;

	@Autowired
	private GpsDao gpsDao;

	@Override
	public List<TrackDto> getLatestTracks() {
		List<GPS> latestGpsEntities = gpsDaoCustom.getLatestBasedOnMetadataTime();
		Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new GsonUtcDateAdapter()).create();

		List<TrackDto> trackDtos = new ArrayList<>();
		latestGpsEntities.forEach(latest -> {
			Metadata metadata = gson.fromJson(latest.getMetadata(), Metadata.class);
			trackDtos.add(new TrackDto(latest.getId(), metadata.getName().get(), metadata.getDescription().get()));
		});

		return trackDtos;
	}

	@Override
	public TrackDetailsDto viewDetails(int trackId) throws JsonParseException, JsonMappingException, IOException {
		Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new GsonUtcDateAdapter()).create();
		
		TrackDetailsDto trackDetailsDto = new TrackDetailsDto();
		
		GPS gps = gpsDao.findOne(trackId);
		trackDetailsDto.setGpsId(gps.getId());
		
		// get metadata
		Metadata metadata = gson.fromJson(gps.getMetadata(), Metadata.class);
		trackDetailsDto.setName(metadata.getName().get());
		trackDetailsDto.setDescription(metadata.getDescription().get());
		
		// get waypopints
		Type listType = new TypeToken<ArrayList<WayPoint>>(){}.getType();
		List<WayPoint> waypoints = new Gson().fromJson(gps.getWaypoints(), listType);
//		ObjectMapper mapper = new ObjectMapper();
//		List<WayPoint> waypoints = mapper.readValue(gps.getWaypoints(), new TypeReference<List<WayPoint>>(){});
		
		List<WaypointDto> waypointDtos = new ArrayList<>();
		waypoints.forEach(wp -> {
			waypointDtos.add(new WaypointDto(wp.getName().get(), wp.getLatitude(), wp.getLongitude()));
		});
		trackDetailsDto.setWaypoints(waypointDtos);
		
		// TODO pare more informations such as routes, track segments, etc.

		return trackDetailsDto;
	}

}
