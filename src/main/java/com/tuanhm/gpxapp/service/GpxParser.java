package com.tuanhm.gpxapp.service;

import java.io.IOException;

import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Track;
import io.jenetics.jpx.TrackSegment;

public class GpxParser {
	
	public void readFromFile() throws IOException {
		GPX.read("D:\\Development\\KarrosTech-SWE-Challenge\\sample\\sample.gpx").tracks()
	    .flatMap(Track::segments)
	    .flatMap(TrackSegment::points)
	    .forEach(System.out::println);
	}

}
