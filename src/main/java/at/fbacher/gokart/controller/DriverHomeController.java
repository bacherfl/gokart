package at.fbacher.gokart.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.services.IDriverService;

@RequestScoped
@Named
public class DriverHomeController {
	@Inject
	FacesContext facesContext;
	@Inject
	IDriverService driverService;
	
	public DriverHomeController() {
		
	}
	
	public Driver getDriver() {
		String userName = facesContext.getExternalContext().getUserPrincipal().getName();
		Driver driver = driverService.getDriver(userName);
		return driver;
	}
}
