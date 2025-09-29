package com.spring.service;

import java.util.List;

import com.spring.entity.User;

public interface IUserService {

	public User createUser(User user);
	public List<User> findAllUsers();
	public User findUserById(int id);
	public String updateUser(int id,User user);
	public String deleteUserById(int id);
}
