package com.gautam.employeemanagementboot.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gautam.employeemanagementboot.entity.Location;

@Repository("locationDao")
public class LocationDAOImpl implements LocationDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Integer addLocation(Location loc) throws Exception {
		entityManager.persist(loc);
		return loc.getLocId();
	}

	@Override
	public Integer updateLocation(Integer locId, Location loc) throws Exception {
		Location loc1=entityManager.find(Location.class, locId);
		entityManager.remove(loc1);
		entityManager.persist(loc);
		return loc.getLocId();
	}

	@Override
	public Integer deleteLocation(Integer locId) throws Exception {
		Location loc=entityManager.find(Location.class, locId);
		entityManager.remove(loc);
		return loc.getLocId();
	}

	@Override
	public Optional<Location> getLocation(Integer locId) throws Exception {
		Location loc=entityManager.find(Location.class, locId);
		if(loc==null) return Optional.empty();
		return Optional.ofNullable(loc);
	}

	@Override
	public Optional<List<Location>> getLocations() throws Exception {
		String queryString ="select l from Location l";
		Query query=entityManager.createQuery(queryString);
		List<Location> result = query.getResultList();
		if(result==null || result.isEmpty()) return Optional.empty();
		return Optional.ofNullable(result);
	}

}
