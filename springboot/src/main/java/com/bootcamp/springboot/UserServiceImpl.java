package com.bootcamp.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public User findUserById(Long Id) {
		return userRepository.findUserById(Id);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}


	public User putUserById(Long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setName(user.getName());
			updatedUser.setBirth_date(user.getBirth_date());
			return userRepository.save(updatedUser);
		} else {
			return null;
		}
	}

	public User save(User user) {
		if (user.getName() == null || user.getBirth_date() == null) {
			return null;
		}
		return userRepository.save(user);	
	}


}
