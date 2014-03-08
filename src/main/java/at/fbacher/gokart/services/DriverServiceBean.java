package at.fbacher.gokart.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import at.fbacher.gokart.model.Driver;

@Stateless
public class DriverServiceBean implements IDriverService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6014441806941301200L;
	@Inject EntityManager entityManager;
	
	@Override
	public void addDriver(Driver driver) {
		entityManager.persist(driver);
	}

	@Override
	public void deleteDriver(Driver driver) {
		Driver managedDriver = entityManager.find(Driver.class, driver.getId());
		entityManager.remove(managedDriver);
	}

	@Override
	public void updateDriver(Driver driver) {
		entityManager.merge(driver);
	}

	@Override
	public List<Driver> getDrivers() {
		TypedQuery<Driver> query = entityManager.createNamedQuery(Driver.findAll, Driver.class);
		return query.getResultList();
	}

}
