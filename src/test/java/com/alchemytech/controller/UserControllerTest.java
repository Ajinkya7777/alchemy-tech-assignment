package com.alchemytech.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.alchemytech.dto.UserDTO;
import com.alchemytech.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Mock
	private UserService service;

	@InjectMocks
	private UserController instance;

	@Test
	public void TestGetUserById_Success() {

		// set up test data
		int id = 1;
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		// set up mocks
		doReturn(dto).when(service).getUserById(id);
		// call the method under test
		ResponseEntity<UserDTO> response = instance.getUserById(id);
		// verify mocks
		verify(service, times(1)).getUserById(id);
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
		assertEquals(dto, response.getBody());
	}

	@Test
	public void TestGetUserById_Failure() {
		// set up test data
		int id = 1;
		// set up mocks
		doReturn(null).when(service).getUserById(id);
		// call the method under test
		ResponseEntity<UserDTO> response = instance.getUserById(id);
		// verify mocks
		verify(service, times(1)).getUserById(id);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Status code should be 404");
	}

	@Test
	public void TestCreateUser_Success() {
		// set up test data
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		// set up mocks
		doReturn(dto).when(service).createUser(dto);
		// call the method under test
		ResponseEntity<UserDTO> response = instance.createUser(dto);
		// verify mocks
		verify(service, times(1)).createUser(dto);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Status code should be 201");
		assertEquals(dto, response.getBody());
	}

	@Test
	public void TestCreateUser_Failure() {
		// set up mocks
		doReturn(null).when(service).createUser(null);
		// call the method under test
		ResponseEntity<UserDTO> response = instance.createUser(null);
		// verify mocks
		verify(service, times(1)).createUser(null);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Status code should be 404");
	}

	@Test
	public void TestUpdateUser_Success() {
		// set up test data
		int id = 1;
		String str = "User Updated Successfully...!";
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		// set up mocks
		doReturn(str).when(service).updateUser(id, dto);
		// call the method under test
		ResponseEntity<String> response = instance.updateUser(id, dto);
		// verify mocks
		verify(service, times(1)).updateUser(id, dto);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
		assertEquals(str, response.getBody());
	}

	@Test
	public void TestUpdateUser_Failure() {
		// set up test data
		int id = 1;
		String str = "User not found...!";
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		// set up mocks
		doReturn(str).when(service).updateUser(id, dto);
		// call the method under test
		ResponseEntity<String> response = instance.updateUser(id, dto);
		// verify mocks
		verify(service, times(1)).updateUser(id, dto);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
	}

	@Test
	public void TestDeleteUser_Success() {
		// set up test data
		int id = 1;
		String str = "User Deleted Successfully...!";
		// set up mocks
		doReturn(str).when(service).deleteUser(id);
		// call the method under test
		ResponseEntity<String> response = instance.deleteUser(id);
		// verify mocks
		verify(service, times(1)).deleteUser(id);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
		assertEquals(str, response.getBody());
	}

	@Test
	public void TestDeleteUser_Failure() {
		// set up test data
		int id = 1;
		String str = "User Not Found...!";
		// set up mocks
		doReturn(str).when(service).deleteUser(id);
		// call the method under test
		ResponseEntity<String> response = instance.deleteUser(id);
		// verify mocks
		verify(service, times(1)).deleteUser(id);
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
	}

	@Test
	public void TestGetAllUser_Success() {
		// set up test data
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		// set up mocks
		doReturn(List.of(dto)).when(service).getAllUsers();
		// call the method under test
		ResponseEntity<List<UserDTO>> response = instance.getAllUsers();
		// verify mocks
		verify(service, times(1)).getAllUsers();
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
		assertEquals(dto, response.getBody().get(0));
	}

	@Test
	public void TestGetAllUser_Failure() {
		// set up test data
		UserDTO dto = new UserDTO();
		dto.setName("Ajinkya");
		dto.setEmail("Ajinkya@gmail.com");
		dto.setDate("17/03/2024");
		// set up mocks
		doReturn(List.of(dto)).when(service).getAllUsers();
		// call the method under test
		ResponseEntity<List<UserDTO>> response = instance.getAllUsers();
		// verify mocks
		verify(service, times(1)).getAllUsers();
		// assertions
		assertNotNull(response, "Response should not be NULL");
		assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200");
	}

}
