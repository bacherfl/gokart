package at.fbacher.gokart.data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.model.RaceResult;
import at.fbacher.gokart.services.IDriverService;
import at.fbacher.gokart.util.Events.Added;

@SessionScoped
@Named
public class DriverListProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1750658761733143889L;
	
	@Inject
	private IDriverService driverService;
	private List<Driver> drivers;

	public DriverListProducer() {
		
	}
	
	@Produces
	@Named
	public List<Driver> getDrivers() {
		List<Driver> drivers = driverService.getDrivers();
		if (drivers != null) {
			Collections.sort(drivers);
		}
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public int getDriverPosition(Driver driver) {
		int result = 1;
		List<Driver> drivers = getDrivers();
		if (drivers != null) {
			for (Driver cmpDriver : drivers) {
				if (cmpDriver.getEmail().equalsIgnoreCase(driver.getEmail())) 
					return result;
				result++;
			}
		}
		return result;
	}

}
