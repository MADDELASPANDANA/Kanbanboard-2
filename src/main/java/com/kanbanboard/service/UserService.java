package com.kanbanboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kanbanboard.entity.User;
import com.kanbanboard.entity.UserDTO;
import com.kanbanboard.exception.UserNotFoundException;


	public interface UserService {
		
		User createRegister(UserDTO userDTO);

		User updateUser(UserDTO userDTO) throws UserNotFoundException;

		String deleteUser(UserDTO userDTO);

		public List<User> showAllUsers();
		public User getUserById(Integer customerId) throws UserNotFoundException;

		List<User> updateUser(UserDTO userDTO, Integer userId);

		List<User> getAllUers();

		List<User> getAllUsers();
	}




