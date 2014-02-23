package at.fbacher.gokart.services;

import java.util.List;

import at.fbacher.gokart.model.Race;

public interface IRaceService {
	
	public void addRace(Race race);
	public void deleteRace(Race race);
	public void updateRace(Race race);
	public List<Race> getRaces();

}
