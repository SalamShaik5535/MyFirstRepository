package com.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.entity.Order;
import com.Spring.repo.IOrderRepo;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepo orderRepo;
	@Override
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public List<Order> listAllOrder() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		Optional<Order> opt = orderRepo.findById(id);
		Order order = null;
		if(opt.isPresent()) {
			order=opt.get();
		}
		return order;
	}

	@Override
	public String updateOrder(Long id, Order order) {
	Optional<Order> opt = orderRepo.findById(id);
	Order or = null;
	if(opt.isPresent()) {
		or.setName(order.getName());
		or.setPrice(order.getPrice());
	}
		return "Order Details Updated With Id "+order.getId();
	}

	@Override
	public String deleteOrder(Long id) {
		orderRepo.deleteById(id);
		return "Order Deleted With Id :"+id;
	}

}
