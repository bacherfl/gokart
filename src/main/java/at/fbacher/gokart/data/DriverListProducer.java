package at.fbacher.gokart.data;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.services.IDriverService;

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
		return driverService.getDrivers();
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

}
