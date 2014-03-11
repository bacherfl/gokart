package at.fbacher.gokart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RaceResult implements Comparable<RaceResult>{
	
	@GeneratedValue
	@Id
	private long id;
	@ManyToOne
	private Race race;
	@ManyToOne
	private Driver driver;
	private int position;
	private float points;
	
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public int compareTo(RaceResult o) {
		//usually, we want to get the results in DESCENDING order, thus inverse the comparison
		if (position > o.position)
			return -1;
		else if(position == o.position)
			return 0;
		else return 1;
	}

}
