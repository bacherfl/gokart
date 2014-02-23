package at.fbacher.gokart.model;

import java.util.List;

public class Driver {
	
	private long id;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private String email;
	private float points;
	private PositionTrend positionTrend;
	private String skills;
	private List<RaceResult> raceResults;
	private String alias;
	private String password;
	
	public enum PositionTrend {UP, DOWN, NIL }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public PositionTrend getPositionTrend() {
		return positionTrend;
	}

	public void setPositionTrend(PositionTrend positionTrend) {
		this.positionTrend = positionTrend;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<RaceResult> getRaceResults() {
		return raceResults;
	}

	public void setRaceResults(List<RaceResult> raceResults) {
		this.raceResults = raceResults;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	};

}
