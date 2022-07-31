package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@Autowired
	UserFeedDAO dao;
	
	@PostMapping("/insert")
	public UserFeedback insert(@RequestBody UserFeedback u) {
		return dao.insertOne(u);
	}
	
	@PostMapping("/insertAll")
	public List<UserFeedback> insertAll(@RequestBody List<UserFeedback> u){
		return dao.insertAll(u);
	}
	
	@GetMapping("/getAll")
	public List<UserFeedback> getAll() {
		return dao.getAll();
	}
	
	@GetMapping("/getByName/{name}")
	public UserFeedback getByName(@PathVariable String name) {
		return dao.getByName(name);
	}
}
