package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFeedDAO {

	@Autowired
	UserFeedRepo repo;
	
	public UserFeedback insertOne(UserFeedback u) {
		return repo.save(u);
	}
	
	public List<UserFeedback> insertAll(List<UserFeedback> u){
		return repo.saveAll(u);
	}
	public List<UserFeedback> getAll() {
	return	repo.findAll();
	}
	
	public UserFeedback getById(int id) {
		return repo.findById(id);
	}
	public UserFeedback getByName(String name) {
		return repo.findByName(name);
	}
}
