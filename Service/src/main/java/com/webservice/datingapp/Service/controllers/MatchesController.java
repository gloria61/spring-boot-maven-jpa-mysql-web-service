package com.webservice.datingapp.Service.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.datingapp.Service.models.MatchesModel;
import com.webservice.datingapp.Service.repositories.MatchesRepository;

@RestController
public class MatchesController {
	
	@Autowired
	MatchesRepository repository;
	
	@GetMapping("/matches")
	public List<MatchesModel> getAllUsers(){
		return repository.findAll();
	}

	@PostMapping("/matches")
	public MatchesModel createMatch(@Valid @RequestBody MatchesModel match) {
		return repository.save(match);
	}
	
	@GetMapping("/matches/{id}")
    public Optional<MatchesModel> getNoteById(@PathVariable(value = "id") Long idStudent) {
        return repository.findById(idStudent);
    }
	
	@PutMapping("/matches/{id}")
    public MatchesModel updateNote(@PathVariable(value = "id") Long idStudent,
                                @Valid @RequestBody MatchesModel matchesDetails) {
		
		Optional<MatchesModel> optionalMatch = repository.findById(idStudent);
		MatchesModel match = optionalMatch.get();
		
		match.setDecision(matchesDetails.getDecision());
				
        return repository.save(match);
    }
	
	 @DeleteMapping("/matches/{id}")
	 public ResponseEntity<?> deleteMatch(@PathVariable(value = "id") Long idStudent) {
		    Optional<MatchesModel> optionalMatch = repository.findById(idStudent);
			MatchesModel match = optionalMatch.get();

	        repository.delete(match);

	        return ResponseEntity.ok().build();
	    }
}
