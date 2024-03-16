package com.alchemytech.mapper;

import org.springframework.stereotype.Component;

import com.alchemytech.dto.UserDTO;
import com.alchemytech.entity.UserEntity;

@Component
public class MapperClass {

	public UserEntity dtoToEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setDate(dto.getDate());
		return entity;
	}

	public UserDTO entityToDto(UserEntity entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setDate(entity.getDate());
		return dto;
	}
}
