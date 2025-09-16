package com.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.entity.User;
import com.Spring.repo.IUserRepo;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	public IUserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> listAll() {
		return userRepo.findAll();
	}

	@Override
	public User findUser(Long id) {
		Optional<User> opt = userRepo.findById(id);
		User user = null;
		if(opt.isPresent()) 
			 user = opt.get();
		return  user;
	}

	@Override
	public String updateUser(Long id, User user) {
		User u = new User();
		Optional<User> opt = userRepo.findById(id);
		if(opt.isPresent()) {
			u.setName(user.getName());
			u.setAddrs(user.getAddrs());
		}
		userRepo.save(u);
		return "User Updated With :"+user.getName()+" "+user.getAddrs();
		
	}

	@Override
	public String  deleteUser(Long id) {
		userRepo.deleteById(id);
		return "User Delete With Id:"+id;
	}

}
