package com.webservice.datingapp.Service;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "users_matches",
						joinColumns = {@JoinColumn(name = "matches_idStudent")},
						inverseJoinColumns={@JoinColumn(name="users_idStudent")})
    Set<MatchesModel> matchesModel;
	
	private String name;
	
	private String surname;
	
	private int age;
	
	private String emailAdress;
	
	private int gender;
	
	private int sexuality;
	
	private int prefrence;
	
	private int department;
	
	private long phoneNumber;
	
	private String password;
	
	private int points;
	
	public Long getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getSexuality() {
		return sexuality;
	}
	public void setSexuality(int sexuality) {
		this.sexuality = sexuality;
	}
	public int getPrefrence() {
		return prefrence;
	}
	public void setPrefrence(int prefrence) {
		this.prefrence = prefrence;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
}
