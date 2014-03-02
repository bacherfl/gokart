package at.fbacher.gokart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRole {

	@GeneratedValue
	@Id
	private long id;
	private String email;
	private String role;
}
