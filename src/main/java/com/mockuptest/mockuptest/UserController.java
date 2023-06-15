package com.mockuptest.mockuptest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockuptest.mockuptest.UserRepository;
import com.mockuptest.mockuptest.User;
import com.mockuptest.mockuptest.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable long userid){
		User user = userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User not exist"));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/users/{userid}")
	public ResponseEntity<User> updateUser(@PathVariable Long userid, @RequestBody User userDetails){
		User user = userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("User not Exist"));
		
		user.setNamalengkap(userDetails.getNamalengkap());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		user.setStatus(userDetails.getStatus());
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long userid){
		User user = userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("user not existed"));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
