package com.kanbanboard.service;

import com.kanbanboard.entity.User;
import com.kanbanboard.entity.UserDTO;
import com.kanbanboard.exception.UserNotFoundException;
import com.kanbanboard.repository.UserRepository;

import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;

	

	@Service // @Component
	public class UserServiceImpl implements UserService {

		@Autowired
		private UserRepository userRepo;

		public User createRegister(UserDTO userDTO) {
			System.out.println("UserServiceImpl -- addUser");

			User cust = new User();

			cust.setUserId(userDTO.getUserId());
			cust.setFirstname(userDTO.getFirstname());
			cust.setLastname(userDTO.getLastname());
			cust.setEmail(userDTO.getEmail());
			cust.setPwd(userDTO.getPwd());
			

			System.out.println(cust);
			return this.userRepo.save(cust);
		}

		//@PutMapping("/updateUser/{userId}")
		public User updateUser(UserDTO userDTO) throws UserNotFoundException {

			Optional<User> userOpt = this.userRepo.findById(userDTO.getUserId());
			if (userOpt.isEmpty())
				throw new UserNotFoundException("User id does not exist to update.");

			User updateUser = userOpt.get();
			updateUser.setFirstname(userDTO.getFirstname());
			updateUser.setLastname(userDTO.getLastname());
			updateUser.setEmail(userDTO.getEmail());
			updateUser.setPwd(userDTO.getPwd());
			
			return this.userRepo.save(updateUser);
		}

		//@PostMapping("/getData")
		public List<User> updateUser(UserDTO userDTO, Integer userId) {
			System.out.println("User controller  --- getUser");
			List<User> data = userRepo.findAll();
			return data;
		}

		//@DeleteMapping("/deleteUsmer/{userId}")
		public String deleteUser(Integer userId) throws UserNotFoundException {
			Optional<User> userOpt = this.userRepo.findById(userId);
			if (userOpt.isEmpty())
				throw new UserNotFoundException("User id does not exist to delete.");
			this.userRepo.deleteById(userId);
			String messageBody = "{message:'User deleted successfully'}";
			return messageBody;
			//return "User deleted successfully";
		}

		public List<User> showAllUsers() {

			return this.userRepo.findAll();
		}

		public User getUserById(long userId) throws UserNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String deleteUser(UserDTO userDTO) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User getUserById(Integer userId) throws UserNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<User> getAllUsers() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<User> getAllUers() {
			// TODO Auto-generated method stub
			return null;
		}

	}



