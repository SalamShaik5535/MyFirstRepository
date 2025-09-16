package com.Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.entity.User;

public interface IUserRepo extends JpaRepository<User, Long> {
	

}
