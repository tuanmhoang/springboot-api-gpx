package com.tuanhm.gpxapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tuanhm.gpxapp.entity.GPS;

@Repository
public interface GpsDaoCustom {

	List<GPS> getLatestBasedOnMetadataTime();
}
