package at.fbacher.gokart.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import at.fbacher.gokart.controller.EditDriverController.Mode;
import at.fbacher.gokart.data.RaceListProducer;
import at.fbacher.gokart.model.Driver;
import at.fbacher.gokart.model.Race;
import at.fbacher.gokart.model.RaceResult;
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
	List<Driver> drivers;
	private Race race;
	private Mode mode;
	private DualListModel<Driver> driversAndResults;
	@Inject @Added
	private Event<RaceResult> raceResultAddedEvent;
	
	public EditRaceController() {
		
	}
	
	private void initDriversAndResults() {
		ArrayList<Driver> resultDrivers = initRaceResultDrivers();
		ArrayList<Driver> availableDrivers = initAvailableDrivers(resultDrivers);	
		
		driversAndResults = new DualListModel<Driver>(availableDrivers, resultDrivers);
	}
	
	private ArrayList<Driver> initRaceResultDrivers() {
		ArrayList<Driver> resultDrivers = new ArrayList<Driver>();
		if (race.getRankings() != null) {
			for (RaceResult result : race.getRankings()) {
				resultDrivers.add(result.getDriver());
			}
		}
		return resultDrivers;
	}
	
	private ArrayList<Driver> initAvailableDrivers(ArrayList<Driver> resultDrivers) {
		ArrayList<Driver> availableDrivers = new ArrayList<Driver>();
		if (drivers != null) {
			for (Driver driver : drivers) {
				boolean found = false;
				if (!resultDrivers.isEmpty()) {
					for (Driver tmpDriver : resultDrivers) {
						if (driver.getEmail().equalsIgnoreCase(tmpDriver.getEmail())) 
							found = true;
					}
				}
				if (!found) {
					availableDrivers.add(driver);
				}
			}
		}
		return availableDrivers;
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
		initDriversAndResults();
	}
	
	public void setRaceToEdit(Mode mode) {
		setRaceToEdit(mode, new Race());
	}
	
	public String doSave() {
		if (mode == Mode.ADD) {
			raceListProducer.addRace(race);
		} else {
			updateRaceResults();
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
	
	private void updateRaceResults() {
		List<RaceResult> results = new ArrayList<RaceResult>();
		int i = 1;
		//TODO implement a converter for the picklist to get Driver objects from target list
		for (Driver driver : driversAndResults.getTarget()) {
			RaceResult result = new RaceResult();
			result.setRace(race);
			result.setDriver(driver);
			result.setPosition(i++);
			results.add(result);
			raceResultAddedEvent.fire(result);
		}
		race.setRankings(results);
	}
	
}
