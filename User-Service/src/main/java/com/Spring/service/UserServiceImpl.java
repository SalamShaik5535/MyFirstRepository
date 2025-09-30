package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(int id) {
	return userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		
		
	}

	@Override
	public String updateUser(int id, User user) {
		User u = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));
		if(u!=null) {
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setContact(user.getContact());
			u.setAddrs(user.getAddrs());
			userRepo.save(u);
		}
		return "User Details Updated "+id;
	}

	@Override
	public String deleteUserById(int id) {
		userRepo.deleteById(id);
		return "User Deleted With"+id;
	}

	
}
