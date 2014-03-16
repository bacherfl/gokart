package at.fbacher.gokart.data;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import at.fbacher.gokart.model.Race;
import at.fbacher.gokart.model.Race.RaceStatus;
import at.fbacher.gokart.services.IRaceService;

@RequestScoped
@Named
public class RaceListProducer {
	
	@Inject
	private IRaceService raceService;
	
	public RaceListProducer() {
		
	}
	
	@Produces
	@Named
	public List<Race> getRaces() {
		return raceService.getRaces();
	}
	
	@Produces
	@Named
	public Race getNextRace() {
		List<Race> races = getRaces();
		if (!races.isEmpty()) {
			Race nextRace = races.get(0);
			if (nextRace.getStatus() == RaceStatus.UPCOMING) {
				return races.get(0);
			} else {
				return null;
			}
		}
		else return null;
	}
	
	public void addRace(Race race) {
		race.setStatus(RaceStatus.UPCOMING);
		raceService.addRace(race);
	}
	
	public void updateRace(Race race) {
		raceService.updateRace(race);
	}
}
