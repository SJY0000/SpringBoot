package com.myapp.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.mybatis.mapper.UserMapper;
import com.myapp.mybatis.model.User;

@RestController // view 없이 바로 return
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserMapper usermapper;
	
	@GetMapping("/{id}")
	public  User getUser(@PathVariable("id") String id) {
		// mybatis는 repository 대신 매퍼를 만듬 
		User user = usermapper.getUser(id);
				
		return user;
	}
	@GetMapping
	public List<User> getUserList() {
		List<User> userList = usermapper.getUserList();
		
		return userList;
	}
	@PostMapping
	public void createUser(@RequestParam("id") String id, @RequestParam("name") String name, 
							@RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		usermapper.insertUser(id, name, phone, address);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable("id") String id, @RequestParam("name") String name, 
							@RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		usermapper.updateUser(id, name, phone, address);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		usermapper.deleteUser(id);
	}
}
