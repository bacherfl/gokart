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
	private float avgLapTime;
	private float bestLapTime;
	
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
		switch (position) {
			case 1: setPoints(25.0f); break;
			case 2: setPoints(18.0f); break;
			case 3: setPoints(15.0f); break;
			case 4: setPoints(12.0f); break;
			case 5: setPoints(10.0f); break;
			case 6: setPoints(8.0f); break;
			case 7: setPoints(6.0f); break;
			case 8: setPoints(4.0f); break;
			case 9: setPoints(2.0f); break;
			case 10: setPoints(1.0f); break;
			default: setPoints(0.0f); break;
		}
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
	public float getAvgLapTime() {
		return avgLapTime;
	}
	public void setAvgLapTime(float avgLapTime) {
		this.avgLapTime = avgLapTime;
	}
	public float getBestLapTime() {
		return bestLapTime;
	}
	public void setBestLapTime(float bestLapTime) {
		this.bestLapTime = bestLapTime;
	}	
}
