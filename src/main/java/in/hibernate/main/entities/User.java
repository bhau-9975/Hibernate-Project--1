package in.hibernate.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity; // Don't use this annotation of hibernate
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Table(name="Another_Table_Name")   // or we can give custom name also
@Entity // It tells that this is an entity class
@Table // It tells that the name of the table should be same as the name of the class
public class User {

	@Id // It is used to generate an unique id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // It is used generate Id automatically so no need to set the id
														// in main class
	@Column // It tells that the name of the column should be same as the name of the
			// variable
	private long id;

	@Column(name = "name") // or we can give custom name also
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private String gender;

	@Column
	private String city;

	public User() {
	}

	public User(long id, String name, String email, String password, String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.city = city;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
