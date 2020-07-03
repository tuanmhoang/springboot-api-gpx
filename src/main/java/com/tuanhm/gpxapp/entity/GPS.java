package com.tuanhm.gpxapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_DATA")
public class GPS {

	@Id
	@GeneratedValue
	@Column(name = "Id", nullable = false)
	private int id;

	@Column(name = "metadata", columnDefinition = "TEXT")
	private String metadata;

	@Column(name = "waypoints", columnDefinition = "TEXT")
	private String waypoints;

	@Column(name = "routes", columnDefinition = "TEXT")
	private String routes;

	@Column(name = "tracks", columnDefinition = "TEXT")
	private String tracks;
	
	@Column(name = "uploaded_time")
	private Date uploadedTime;
	
	@Column(name = "metadata_time")
	private Date metadataTime;
	
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

	public Date getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(Date uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public Date getMetadataTime() {
		return metadataTime;
	}

	public void setMetadataTime(Date metadataTime) {
		this.metadataTime = metadataTime;
	}

}
