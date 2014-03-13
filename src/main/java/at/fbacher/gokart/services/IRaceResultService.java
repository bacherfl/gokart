package at.fbacher.gokart.services;

import java.util.List;

import at.fbacher.gokart.model.RaceResult;

public interface IRaceResultService {
	public void addRaceResult(RaceResult raceResult);
	public void deleteRaceResult(RaceResult raceResult);
	public void updateRaceResult(RaceResult raceResult);
	public List<RaceResult> getRaceResults();
}
