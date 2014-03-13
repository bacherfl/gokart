package at.fbacher.gokart.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries({
	@NamedQuery(name="Race.findAll",query="SELECT r FROM Race r ORDER BY r.date")
})
@Entity
public class Race {
	
	public static final String findAll = "Race.findAll";
	
	@GeneratedValue
	@Id
	private long id;
	private String name;
	private String location;
	private Date date;
	@OneToMany
	private List<Driver> confirmedDrivers;
	private RaceStatus status;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "race")
	private List<RaceResult> rankings;
	
	public enum RaceStatus {UPCOMING, COMPLETED, CANCELLED }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Driver> getConfirmedDrivers() {
		return confirmedDrivers;
	}

	public void setConfirmedDrivers(List<Driver> confirmedDrivers) {
		this.confirmedDrivers = confirmedDrivers;
	}

	public RaceStatus getStatus() {
		return status;
	}

	public void setStatus(RaceStatus status) {
		this.status = status;
	}

	public List<RaceResult> getRankings() {
		if (rankings != null) {
			Collections.sort(rankings);
		}
		
		return rankings;
	}

	public void setRankings(List<RaceResult> rankings) {
		this.rankings = rankings;
	}
	
	
}
