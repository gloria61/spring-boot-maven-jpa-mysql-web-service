package com.webservice.datingapp.Service;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users_matches")
@EntityListeners(AuditingEntityListener.class)
public class UsersMatchesModel implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "users_idStudent")
	private UserModel users_idStudent;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "matches_idStudent")
	private MatchesModel matches_idStudent;
	
	/*@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "EMP_ID")
    private Employee employee;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUsers_idStudent() {
		return users_idStudent;
	}

	public void setUsers_idStudent(UserModel users_idStudent) {
		this.users_idStudent = users_idStudent;
	}

	public MatchesModel getMatches_idStudent() {
		return matches_idStudent;
	}

	public void setMatches_idStudent(MatchesModel matches_idStudent) {
		this.matches_idStudent = matches_idStudent;
	}
	
	
}
