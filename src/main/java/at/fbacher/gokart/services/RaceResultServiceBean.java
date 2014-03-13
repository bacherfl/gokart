package at.fbacher.gokart.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import at.fbacher.gokart.model.RaceResult;

@Stateless
public class RaceResultServiceBean implements IRaceResultService {

	@Inject
	private EntityManager entityManager;
	
	@Override
	public void addRaceResult(RaceResult raceResult) {
		entityManager.persist(raceResult);

	}

	@Override
	public void deleteRaceResult(RaceResult raceResult) {
		RaceResult managedRaceResult = entityManager.find(RaceResult.class, raceResult.getId());
		entityManager.remove(managedRaceResult);
		entityManager.flush();
	}

	@Override
	public void updateRaceResult(RaceResult raceResult) {
		// TODO

	}

	@Override
	public List<RaceResult> getRaceResults() {
		// TODO Auto-generated method stub
		return null;
	}

}
