package at.fbacher.gokart.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Race;

@ViewScoped
@Named
public class RaceListController {
	
	@Inject
	ViewRaceController viewRaceController;
	
	public RaceListController() {
		
	}
	
	public String doViewRace(Race race) {
		viewRaceController.setRace(race);
		return Pages.VIEW_RACE;
	}
}
