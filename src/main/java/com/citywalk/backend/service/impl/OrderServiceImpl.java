package com.citywalk.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.Order;
import com.citywalk.backend.repositary.OrderRepositary;
import com.citywalk.backend.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepositary orderRepositary;

	@Override
	public Order save(Order order) throws CitywalkException {
		order = orderRepositary.save(order);
		return order;
	}

	@Override
	public void delete(int id) throws CitywalkException {
		orderRepositary.delete(id);
		return;
	}

	@Override
	public List<Order> findAll() throws CitywalkException {
		List<Order> orders = orderRepositary.findAll();
		return orders;
	}

	@Override
	public Order update(Order order) throws CitywalkException {
		Order updatedOrder = order = orderRepositary.update(order);
		return updatedOrder;
	}

	@Override
	public Order findById(int id) throws CitywalkException {
		Order order = orderRepositary.findById(id);
		return order;
	}

}
