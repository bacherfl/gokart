package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.services.IDriverService;

@SessionScoped
@Named
public class EditDriverController implements Serializable {

	public enum Mode {
		EDIT, ADD
	};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2990109784280885969L;
	private Driver driver;
	@Inject
	private IDriverService driverService;
	private Mode mode;
	
	public EditDriverController() {

	}
	
	
	public void setDriverToEdit(Mode mode) {
		setDriverToEdit(mode, new Driver());
	}
	
	public void setDriverToEdit(Mode mode, Driver driver) {
		this.driver = driver;
		setMode(mode);
	}
	
	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public String doSave() {
		if (mode == Mode.ADD) {
			driverService.addDriver(driver);
		} else {
			driverService.updateDriver(driver);
		}
		return Pages.DRIVER_LIST;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTitle() {
		if (mode == Mode.ADD) {
			return "Add a new driver";
		} else {
			return "Edit Driver";
		}
	}

}
