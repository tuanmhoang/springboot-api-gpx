package com.tuanhm.gpxapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tuanhm.gpxapp.entity.GPS;

@Repository
public class GpsDaoCustomImpl implements GpsDaoCustom {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<GPS> getLatestBasedOnMetadataTime(){
	    CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
	    CriteriaQuery<GPS> criteriaQuery  = criteriaBuilder.createQuery(GPS.class);
	    Root<GPS> root = criteriaQuery.from(GPS.class);
	    criteriaQuery.select(root);
	    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("metadataTime")));
		
		return entityManager.createQuery(criteriaQuery).setMaxResults(10).getResultList();
	}
}
