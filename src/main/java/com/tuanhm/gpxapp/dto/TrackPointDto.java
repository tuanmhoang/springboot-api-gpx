package com.tuanhm.gpxapp.dto;

import java.util.Date;

public class TrackPointDto {
	private Number lat;
	private Number lon;
	private Number ele;
	private Date time;
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
	public Number getEle() {
		return ele;
	}
	public void setEle(Number ele) {
		this.ele = ele;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
