package com.alchemytech.service;

import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alchemytech.dto.UserDTO;
import com.alchemytech.entity.UserEntity;
import com.alchemytech.mapper.MapperClass;
import com.alchemytech.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository repository;

	@Mock
	private MapperClass mapper;

	@InjectMocks
	private UserServiceImpl instance;

	@Test
	public void TestGetUserById_Success() {
		// set up test data
		int userId = 1;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		userEntity.setName("Ajinkya Shinde");
		UserDTO expectedUserDTO = new UserDTO();
		expectedUserDTO.setId(userId);
		expectedUserDTO.setName("Ajinkya Shinde");
		// set up mocks
		doReturn(Optional.of(userEntity)).when(repository).findById(userId);
		doReturn(expectedUserDTO).when(mapper).entityToDto(userEntity);

		// call the method under test
		UserDTO response = instance.getUserById(userId);

		// verify mocks
		verify(repository).findById(userId);
		verify(mapper).entityToDto(userEntity);

		// assertions
		assertEquals(expectedUserDTO, response);
	}

	@Test
	public void TestGetUserById_Failure() {
		// set up test data
		int userId = 1;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		userEntity.setName("Ajinkya Shinde");
		UserDTO expectedUserDTO = new UserDTO();
		expectedUserDTO.setId(userId);
		expectedUserDTO.setName("Ajinkya Shinde");
		// set up mocks
		doReturn(Optional.of(userEntity)).when(repository).findById(userId);
		doReturn(null).when(mapper).entityToDto(userEntity);

		// call the method under test
		UserDTO response = instance.getUserById(userId);

		// verify mocks
		verify(repository).findById(userId);
		verify(mapper).entityToDto(userEntity);

		// assertions
		assertNull(response, "Response should be NULL");
	}

	@Test
	public void TestCreateUser_Success() {
		// set up test data
		int userId = 1;
		UserDTO dto = new UserDTO();
		dto.setId(userId);
		dto.setName("Ajinkya Shinde");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		UserEntity entity = new UserEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setDate(dto.getDate());
		// set up mocks
		doReturn(entity).when(mapper).dtoToEntity(dto);
		doReturn(entity).when(repository).save(entity);
		doReturn(dto).when(mapper).entityToDto(entity);

		// call the method under test
		UserDTO response = instance.createUser(dto);

		// verify mocks
		verify(mapper).dtoToEntity(dto);
		verify(repository).save(entity);
		verify(mapper).entityToDto(entity);

		// assertions
		assertEquals(dto, response);
	}

	@Test
	public void TestUpdateUser_Success() {
		// set up test data
		int userId = 1;
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");

		UserEntity entity = new UserEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setDate(dto.getDate());
		// set up mocks
		doReturn(Optional.of(entity)).when(repository).findById(userId);

		// call the method under test
		String response = instance.updateUser(userId, dto);

		// verify mocks
		verify(repository).findById(userId);
		verify(repository).save(entity);

		// assertions
		assertEquals("User Updated Successfully..!", response);
	}

	@Test
	public void TestUpdateUser_Failure() {
		// set up test data
		int userId = 1;
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");

		// set up mocks
		doReturn(Optional.empty()).when(repository).findById(userId);

		// call the method under test
		String response = instance.updateUser(userId, dto);

		// verify mocks
		verify(repository).findById(userId);
		verify(repository, times(0)).save(any());

		// assertions
		assertEquals("User not found...!", response);

	}

	@Test
	public void TestDeleteUser_Success() {
		// set up test data
		int userId = 1;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		userEntity.setName("Ajinkya Shinde");
		// set up mocks
		doReturn(Optional.of(userEntity)).when(repository).findById(userId);

		// call the method under test
		String response = instance.deleteUser(userId);

		// verify mocks
		verify(repository).findById(userId);
		verify(repository).deleteById(userId);
		// assertions
		assertEquals("User Deleted Successfully...!", response);
	}

	@Test
	public void TestDeleteUser_Failure() {
		// set up test data
		int userId = 1;
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userId);
		userEntity.setName("Ajinkya Shinde");
		// set up mocks
		doReturn(Optional.empty()).when(repository).findById(userId);

		// call the method under test
		String response = instance.deleteUser(userId);

		// verify mocks
		verify(repository).findById(userId);
		verify(repository, times(0)).deleteById(userId);
		// assertions
		assertEquals("User Not Found...!", response);
	}

}
