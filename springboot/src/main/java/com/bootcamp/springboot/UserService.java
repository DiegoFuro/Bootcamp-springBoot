package com.bootcamp.springboot;

import org.springframework.stereotype.Service;

public interface UserService {

	User findUserById(Long Id);

	void deleteUserById(Long id);

	User putUserById(Long id, User user);

	User save(User user);


}
