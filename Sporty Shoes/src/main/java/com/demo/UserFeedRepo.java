package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface UserFeedRepo extends JpaRepository<UserFeedback, Integer> {

	@Query("select u from UserFeedback u where u.userid=?1")
	public UserFeedback findById(int id);
	
	@Query("select u from UserFeedback u where u.name=?1")
	public UserFeedback findByName(String name);
}
