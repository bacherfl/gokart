package at.fbacher.gokart.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import at.fbacher.gokart.model.Race;

public class RaceServiceBean implements IRaceService {
	
	@Inject
	private EntityManager entityManager;
	
	@Override
	public void addRace(Race race) {
		entityManager.persist(race);
	}

	@Override
	public void deleteRace(Race race) {
		Race managedRace = entityManager.find(Race.class, race.getId());
		entityManager.detach(managedRace);
	}

	@Override
	public void updateRace(Race race) {
		entityManager.merge(race);
	}

	@Override
	public List<Race> getRaces() {
		TypedQuery<Race> query = entityManager.createNamedQuery(Race.findAll, Race.class);
		return query.getResultList();
	}

}
