package com.bootcamp.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserById(Long id);

	void deleteUserById(Long id);

	User save(User user);



}
