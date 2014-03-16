package at.fbacher.gokart.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;

@ViewScoped
@Named
public class DriverListController {

	@Inject
	ViewDriverController viewDriverController;
	
	public DriverListController() {
		
	}
	
	public String doViewDriver(Driver driver) {
		viewDriverController.setDriver(driver);
		return Pages.VIEW_DRIVER;
	}
}
