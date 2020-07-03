package com.tuanhm.gpxapp.dto;

public class TrackDto {
	private int gpsId;
	private String name;
	private String description;

	public TrackDto() {

	}

	public TrackDto(int gpsId, String name, String description) {
		this.gpsId = gpsId;
		this.name = name;
		this.description = description;
	}

	public int getGpsId() {
		return gpsId;
	}

	public void setGpsId(int gpsId) {
		this.gpsId = gpsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
