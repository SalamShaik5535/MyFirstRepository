package com.Spring.service;

import java.util.List;

import com.Spring.entity.User;

public interface IUserService {
	
	public User createUser(User user);
	public List<User> listAll();
	public User findUser(Long id);
	public String updateUser(Long id,User user);
	public String deleteUser(Long id);
}
