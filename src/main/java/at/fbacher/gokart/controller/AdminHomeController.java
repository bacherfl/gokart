package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.controller.EditDriverController.Mode;
import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.model.Race;
import at.fbacher.gokart.services.IDriverService;
import at.fbacher.gokart.services.IRaceService;

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
	@Inject
	private EditRaceController editRaceController;
	@Inject
	private IRaceService raceService;
	
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
	
	public String doAddDriver() {
		editDriverController.setDriverToEdit(Mode.ADD);
		return Pages.ADMIN_ADD_DRIVER;
	}
	
	public String doAddRace() {
		editRaceController.setRaceToEdit(Mode.ADD);
		return Pages.ADMIN_ADD_RACE;
	}
	
	public String doDeleteRace(Race race) {
		raceService.deleteRace(race);
		return Pages.ADMIN_HOME;
	}
	
	public String doEditRace(Race race) {
		editRaceController.setRaceToEdit(Mode.EDIT, race);
		return Pages.ADMIN_EDIT_RACE;
	}

}
