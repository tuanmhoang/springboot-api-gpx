package com.tuanhm.gpxapp.dto;

/**
 * To parse data from GPS entity.
 * 
 * @author Tuan
 *
 */
public class GpsDto {
	private int id;

	private String metadata;

	private String waypoints;

	private String routes;

	private String tracks;

	private String uploadedTime;

	private String metadataTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(String waypoints) {
		this.waypoints = waypoints;
	}

	public String getRoutes() {
		return routes;
	}

	public void setRoutes(String routes) {
		this.routes = routes;
	}

	public String getTracks() {
		return tracks;
	}

	public void setTracks(String tracks) {
		this.tracks = tracks;
	}

	public String getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(String uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public String getMetadataTime() {
		return metadataTime;
	}

	public void setMetadataTime(String metadataTime) {
		this.metadataTime = metadataTime;
	}

}
