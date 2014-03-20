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
	private int position = 0;
	private int position2 = 0;
	private float points;
	private float avgLapTime;
	private float avgLapTime2;
	private float bestLapTime;
	private float bestLapTime2;
	
	public int getPosition2() {
		return position2;
	}
	public void setPosition2(int position2) {
		this.position2 = position2;
		updatePoints();
	}
	public float getAvgLapTime2() {
		return avgLapTime2;
	}
	public void setAvgLapTime2(float avgLapTime2) {
		this.avgLapTime2 = avgLapTime2;
	}
	public float getBestLapTime2() {
		return bestLapTime2;
	}
	public void setBestLapTime2(float bestLapTime2) {
		this.bestLapTime2 = bestLapTime2;
	}
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
		updatePoints();
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
		if (points > o.getPoints())
			return -1;
		else if(position == o.getPoints()) {
			return compareSecondary(o);
		}
		else return 1;
	}
	private int compareSecondary(RaceResult o) {
		int myBestPosition = Math.min(position2, position);
		int otherBestPosition = Math.min(o.getPosition(), o.getPosition2());
		
		if (myBestPosition < otherBestPosition)
			return -1;
		
		int myWorsePosition = Math.max(position, position2);
		int otherWorstPosition = Math.max(o.getPosition(), o.getPosition2());
		
		if (myWorsePosition < otherWorstPosition)
			return 1;
		
		return 0;
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
	
	private float getPointsForPoisition(int position) {
		switch (position) {
			case 1: return 12.5f; 
			case 2: return 9.0f;
			case 3: return 7.5f; 
			case 4: return 6.0f; 
			case 5: return 5.0f;
			case 6: return 4.0f;
			case 7: return 3.0f;
			case 8: return 2.0f;
			case 9: return 1.0f;
			case 10: return 0.5f;
			default: return 0.0f;
		}
	}
	
	private void updatePoints() {
		points = getPointsForPoisition(position) + getPointsForPoisition(position2);
	}
}
