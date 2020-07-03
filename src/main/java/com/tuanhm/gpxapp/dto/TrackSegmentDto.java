package com.tuanhm.gpxapp.dto;

import java.util.List;

public class TrackSegmentDto {
	private List<TrackPointDto> trackPointDtos;

	public List<TrackPointDto> getTrackPointDtos() {
		return trackPointDtos;
	}

	public void setTrackPointDtos(List<TrackPointDto> trackPointDtos) {
		this.trackPointDtos = trackPointDtos;
	}
}
