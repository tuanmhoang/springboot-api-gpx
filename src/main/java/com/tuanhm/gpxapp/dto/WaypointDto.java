package com.tuanhm.gpxapp.dto;

public class WaypointDto {

	private String name;
	private Number lat;
	private Number lon;

	public WaypointDto() {
	}

	public WaypointDto(String name, Number lat, Number lon) {
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getLat() {
		return lat;
	}

	public void setLat(Number lat) {
		this.lat = lat;
	}

	public Number getLon() {
		return lon;
	}

	public void setLon(Number lon) {
		this.lon = lon;
	}

}
