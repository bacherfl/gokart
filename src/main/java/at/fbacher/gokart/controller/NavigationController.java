package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.controller.EditDriverController.Mode;
import at.fbacher.gokart.model.Driver;

@SessionScoped
@Named
public class NavigationController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4162542156202778589L;
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
		return Pages.ADMIN_ADD_DRIVER;
	}
}
