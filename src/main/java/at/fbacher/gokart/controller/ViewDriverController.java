package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import at.fbacher.gokart.model.Driver;

@SessionScoped
@Named
public class ViewDriverController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5072547605944399828L;
	private Driver driver;
	
	public ViewDriverController() {
		
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Driver getDriver() {
		return driver;
	}
}
