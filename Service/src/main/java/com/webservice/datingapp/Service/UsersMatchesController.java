package com.webservice.datingapp.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersMatchesController {

	@Autowired
	UsersMatchesRepository repository;
	
	@GetMapping("/users-matches")
	public List<UsersMatchesModel> getAllUsers(){
		return repository.findAll();
	}
	
	@PostMapping("/users-matches")
	public UsersMatchesModel createUser(@Valid @RequestBody UsersMatchesModel user) {
		return repository.save(user);
	}
	
	@GetMapping("/users-matches/{id}")
    public Optional<UsersMatchesModel> getNoteById(@PathVariable(value = "id") Long idStudent) {
        return repository.findById(idStudent);
    }
	
	@DeleteMapping("/users-matches/{id}")
	 public ResponseEntity<?> deleteUserMatch(@PathVariable(value = "id") Long id) {
		    Optional<UsersMatchesModel> optionalUserMatch = repository.findById(id);
			UsersMatchesModel userMatch = optionalUserMatch.get();

	        repository.delete(userMatch);

	        return ResponseEntity.ok().build();
	    }
}
