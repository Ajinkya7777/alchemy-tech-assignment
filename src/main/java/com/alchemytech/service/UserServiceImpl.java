package com.alchemytech.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alchemytech.dto.UserDTO;
import com.alchemytech.entity.UserEntity;
import com.alchemytech.mapper.MapperClass;
import com.alchemytech.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repo;
	private MapperClass mapper;

	@Autowired
	public UserServiceImpl(UserRepository repo, MapperClass mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public UserDTO getUserById(int id) {
		UserEntity entity = null;
		Optional<UserEntity> optional = repo.findById(id);
		if (optional.get() != null) {
			entity = optional.get();
		}

		return mapper.entityToDto(entity);
	}

	@Override
	public List<UserDTO> getAllUsers() {

		List<UserEntity> findAll = repo.findAll();
		List<UserDTO> dto = findAll.stream().map(en -> mapper.entityToDto(en)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public UserDTO updateUser(int id, UserDTO dto) {
		UserEntity entity = null;
		Optional<UserEntity> optional = repo.findById(id);
		if (optional.get() != null) {
			entity = optional.get();
		}
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setDate(dto.getDate());
		UserEntity updatedEntity = repo.save(entity);

		return mapper.entityToDto(updatedEntity);
	}

	@Override
	public String deleteUser(int id) {
		repo.deleteById(id);
		return "User Deleted Successfully";
	}

	@Override
	public UserDTO createUser(UserDTO dto) {

		return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
	}

}
