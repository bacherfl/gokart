package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.controller.EditDriverController.Mode;
import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.services.IDriverService;

@SessionScoped
@Named
public class AdminHomeController implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6306675479668144411L;
	
	@Inject
	private EditDriverController editDriverController;
	@Inject
	private IDriverService driverService;
	
	public AdminHomeController() {
		
	}
	
	public String doEditDriver(Driver driver) {
		editDriverController.setDriverToEdit(Mode.EDIT, driver);
		return Pages.ADMIN_EDIT_DRIVER;
	}
	
	public String doDeleteDriver(Driver driver) {
		if (driver.getEmail().equalsIgnoreCase("bacherfl@gmail.com")) {
			return Pages.ADMIN_HOME;
		}
		driverService.deleteDriver(driver);
		return Pages.ADMIN_HOME;
	}

}
