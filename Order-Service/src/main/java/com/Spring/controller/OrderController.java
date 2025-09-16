package com.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.entity.Order;
import com.Spring.service.IOrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		return ResponseEntity.ok(orderService.saveOrder(order));
	}
	@GetMapping("/findAll")
	public ResponseEntity<List<Order>> listAllOrder(){
		return ResponseEntity.ok(orderService.listAllOrder());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Order> getById(@PathVariable Long id){
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable Long id,@RequestBody Order order){
		return ResponseEntity.ok(orderService.updateOrder(id, order));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id){
		return ResponseEntity.ok(orderService.deleteOrder(id));
	}

}
