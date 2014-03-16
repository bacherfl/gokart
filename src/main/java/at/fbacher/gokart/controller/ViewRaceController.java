package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import at.fbacher.gokart.model.Race;

@SessionScoped
@Named
public class ViewRaceController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5214154493189257394L;

	private Race race;
	
	public ViewRaceController() {
		
	}
	
	public void setRace(Race race) {
		this.race = race;
	}
	
	public Race getRace() {
		return race;
	}
}
