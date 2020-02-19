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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.webservice.datingapp.Service.UserModel;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repository;

	@GetMapping("/users")
	public List<UserModel> getAllUsers(){
		return repository.findAll();
	}
	
	@PostMapping("/users")
	public UserModel createUser(@Valid @RequestBody UserModel user) {
		return repository.save(user);
	}
	
	@GetMapping("/notes/{id}")
    public Optional<UserModel> getNoteById(@PathVariable(value = "id") Long idStudent) {
        return repository.findById(idStudent);
    }
	
	@PutMapping("/notes/{id}")
    public UserModel updateNote(@PathVariable(value = "id") Long idStudent,
                                @Valid @RequestBody UserModel userDetails) {
		
		Optional<UserModel> optionalUser = repository.findById(idStudent);
		UserModel user = optionalUser.get();
		
		user.setName(userDetails.getName());
		user.setSurname(userDetails.getSurname());
		user.setAge(userDetails.getAge());
		user.setEmailAdress(userDetails.getEmailAdress());
		user.setGender(userDetails.getGender());
		user.setSexuality(userDetails.getSexuality());
		user.setPrefrence(userDetails.getPrefrence());
		user.setDepartment(userDetails.getDepartment());
		user.setPhoneNumber(userDetails.getPhoneNumber());
		user.setPassword(userDetails.getPassword());
		user.setPoints(userDetails.getPoints());
		
        return repository.save(user);
    }
	
	 @DeleteMapping("/notes/{id}")
	 public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long idStudent) {
		    Optional<UserModel> optionalUser = repository.findById(idStudent);
			UserModel user = optionalUser.get();

	        repository.delete(user);

	        return ResponseEntity.ok().build();
	    }
}
