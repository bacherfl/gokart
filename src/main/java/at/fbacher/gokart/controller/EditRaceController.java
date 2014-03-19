package at.fbacher.gokart.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;

import at.fbacher.gokart.controller.EditDriverController.Mode;
import at.fbacher.gokart.data.RaceListProducer;
import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.model.Race;
import at.fbacher.gokart.model.RaceResult;
import at.fbacher.gokart.services.IRaceResultService;
import at.fbacher.gokart.services.RaceServiceBean;
import at.fbacher.gokart.util.Events.Added;

@SessionScoped
@Named
public class EditRaceController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7108450141507873401L;

	@Inject
	private RaceListProducer raceListProducer;
	@Inject
	private IRaceResultService raceResultService;
	@Inject 
	List<Driver> drivers;
	private Race race;
	private Mode mode;
	private DualListModel<Driver> driversAndResults;
	@Inject @Added
	private Event<RaceResult> raceResultAddedEvent;
	
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
			//updateRaceResults();
			raceListProducer.updateRace(race);
			

			
		}
		return Pages.ADMIN_HOME;
	}
	
	public DualListModel<Driver> getDriversAndResults() {
		return driversAndResults;
	}
	
	public void setDriversAndResults(DualListModel<Driver> driversAndResults) {
		this.driversAndResults = driversAndResults;
	}
	
	public void addResult() {
		RaceResult raceResult = new RaceResult();
		int position = race.getRankings().size() + 1;
		raceResult.setPosition(position);
		raceResult.setRace(race);
		race.getRankings().add(raceResult);
		raceResultService.addRaceResult(raceResult);
		raceListProducer.updateRace(race);
	}
	
	public void onResultEdit(RowEditEvent event) {
		RaceResult result = (RaceResult) event.getObject();
		raceResultService.updateRaceResult(result);
		
		//TODO check if this is necessary
		for (RaceResult tmpResult : race.getRankings()) {
			if (tmpResult.getPosition() == result.getPosition()) {
				tmpResult = result;
			}
		}
		
	}
	
}
