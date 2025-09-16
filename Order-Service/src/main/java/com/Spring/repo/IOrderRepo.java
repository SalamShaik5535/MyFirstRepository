package com.Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.entity.Order;

public interface IOrderRepo extends JpaRepository<Order, Long>{

}
