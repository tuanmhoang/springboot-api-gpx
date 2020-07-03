package com.tuanhm.gpxapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuanhm.gpxapp.entity.GPS;

/**
 * Used to work with repository for GPS
 * @author Tuan
 *
 */
@Repository
public interface GpsDao extends CrudRepository<GPS, Integer>{

}
