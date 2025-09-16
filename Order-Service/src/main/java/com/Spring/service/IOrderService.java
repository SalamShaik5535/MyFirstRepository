package com.Spring.service;

import java.util.List;

import com.Spring.entity.Order;

public interface IOrderService {

	public Order saveOrder(Order order);
	public List<Order> listAllOrder();
	public Order getOrderById(Long id);
	public String updateOrder(Long id,Order order);
	public String deleteOrder(Long id);
}
