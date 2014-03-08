package at.fbacher.gokart.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.controller.EditDriverController.Mode;

@RequestScoped
@Named
public class NavigationController {

	@Inject
	private EditDriverController editDriverController;
	
	public NavigationController() {
		
	}
	
	public String doViewDrivers() {
		return Pages.DRIVER_LIST;
	}
	
	public String doViewRaces() {
		return Pages.RACE_LIST;
	}
	
	public String doViewHome() {
		return Pages.DRIVER_HOME;
	}
	
	public String doAddDriver() {
		editDriverController.setDriverToEdit(Mode.ADD);
		return Pages.ADMIN_EDIT_DRIVER;
	}
}
