package com.tuanhm.gpxapp.dto;

import java.util.List;

public class TrackDetailsDto extends TrackDto {
	
	private List<WaypointDto> waypoints;
	
	private List<TrackSegmentDto> trackSegments;

	public List<WaypointDto> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<WaypointDto> waypoints) {
		this.waypoints = waypoints;
	}

	public List<TrackSegmentDto> getTrackSegments() {
		return trackSegments;
	}

	public void setTrackSegments(List<TrackSegmentDto> trackSegments) {
		this.trackSegments = trackSegments;
	}

}
