package com.tuanhm.gpxapp.service;

import java.util.List;

import com.tuanhm.gpxapp.dto.TrackDetailsDto;
import com.tuanhm.gpxapp.dto.TrackDto;

public interface TracksService {
	/**
	 * Get latest tracks with time based on metadata
	 * @return latest tracks with some general data such as name, description
	 */
	List<TrackDto> getLatestTracks() throws Exception;
	/**
	 * To view details of the track
	 * @param trackId
	 * @return track details view
	 */
	TrackDetailsDto viewDetails(int trackId)  throws Exception;
}