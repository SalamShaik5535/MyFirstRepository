package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer>{

}
