package com.alchemytech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alchemytech.dto.UserDTO;
import com.alchemytech.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id) {
		UserDTO dto = service.getUserById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
		UserDTO newUser = service.createUser(dto);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int id, @RequestBody UserDTO dto) {
		UserDTO userUpdated = service.updateUser(id, dto);
		return new ResponseEntity<>(userUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		String deleteUser = service.deleteUser(id);
		return new ResponseEntity<String>(deleteUser, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> allUsers = service.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(allUsers, HttpStatus.OK);
	}
}
