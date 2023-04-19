package com.bootcamp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = service.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


	@PutMapping(value = "/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
		User updatedUser = service.putUserById(id, user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@PostMapping(value = "/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		service.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
		service.deleteUserById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
	public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
	    return ResponseEntity.badRequest().body(ex.getMessage());
	}

}

