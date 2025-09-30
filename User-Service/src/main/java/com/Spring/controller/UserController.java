package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.ok(userService.createUser(user));
		
	}
	@GetMapping("/listAllUsers")
	public ResponseEntity<List<User>> listAllUsers(){
		return ResponseEntity.ok(userService.findAllUsers());
	}
	@PatchMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id,@RequestBody User user){
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
	@GetMapping("/findUserById/{id}")
	public ResponseEntity<User> findUserById(@PathVariable int id){
		return ResponseEntity.ok(userService.findUserById(id));
	}
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		return ResponseEntity.ok(userService.deleteUserById(id));
	}
}
