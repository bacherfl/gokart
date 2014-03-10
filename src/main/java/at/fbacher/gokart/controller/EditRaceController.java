package at.fbacher.gokart.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.controller.EditDriverController.Mode;
import at.fbacher.gokart.data.RaceListProducer;
import at.fbacher.gokart.model.Race;

@SessionScoped
@Named
public class EditRaceController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7108450141507873401L;

	@Inject
	private RaceListProducer raceListProducer;
	private Race race;
	private Mode mode;
	
	public EditRaceController() {
		
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void setRaceToEdit(Mode mode, Race race) {
		this.mode = mode;
		this.race = race;
	}
	
	public void setRaceToEdit(Mode mode) {
		setRaceToEdit(mode, new Race());
	}
	
	public String doSave() {
		if (mode == Mode.ADD) {
			raceListProducer.addRace(race);
		} else {
			raceListProducer.updateRace(race);
		}
		return Pages.ADMIN_HOME;
	}
}
