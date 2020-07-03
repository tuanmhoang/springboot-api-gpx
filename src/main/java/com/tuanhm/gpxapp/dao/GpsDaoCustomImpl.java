package com.tuanhm.gpxapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tuanhm.gpxapp.entity.GPS;

@Repository
public class GpsDaoCustomImpl implements GpsDaoCustom {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private GpsDao gpsDao;
	
	// TODO check date = today or yesterday to today
	@Override
	public List<GPS> getLatestBasedOnMetadataTime(){
//		Session session = entityManager.unwrap(Session.class);
//		Query query = session.createQuery("from GPS",GPS.class);// where metadata_time = :now ");
//		query.setParameter("now", new Date());
//		List<GPS> gpsData = query.list();
//		return gpsData;
		
	    CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
	    CriteriaQuery<GPS> criteriaQuery  = criteriaBuilder.createQuery(GPS.class);
	    Root<GPS> root = criteriaQuery.from(GPS.class);
//	    Predicate condition = criteriaBuilder.equal(root.get("id"), 1);
	    criteriaQuery.select(root);//.where(condition);
	    
	    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("metadataTime")));
		
		return entityManager.createQuery(criteriaQuery).setMaxResults(10).getResultList();
		
//		
//		Iterable<GPS> findAll = gpsDao.findAll();
//		List<GPS> results = new ArrayList<>();
//		findAll.forEach(results::add);
//	    return results;
	}
}
