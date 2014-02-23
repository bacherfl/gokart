package at.fbacher.gokart.services;

import java.util.List;

import at.fbacher.gokart.model.Driver;

public interface IDriverService {

	public void addDriver(Driver driver);
	public void deleteDriver(Driver driver);
	public void updateDriver(Driver driver);
	public List<Driver> getDrivers();
	
}
