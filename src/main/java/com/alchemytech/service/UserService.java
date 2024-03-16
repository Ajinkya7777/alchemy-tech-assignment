package com.alchemytech.service;

import java.util.List;

import com.alchemytech.dto.UserDTO;

public interface UserService {
	UserDTO getUserById(int id);

	List<UserDTO> getAllUsers();

	UserDTO updateUser(int id, UserDTO dto);

	String deleteUser(int id);

	UserDTO createUser(UserDTO dto);
}
