package com.citywalk.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.Order;
import com.citywalk.backend.repositary.impl.OrderJPARepositary;
import com.citywalk.backend.service.OrderService;

@Service
@Repository
public class OrderServiceImpl implements OrderService{
	
	/*@Autowired
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
	}*/
	
	@Autowired
	private OrderJPARepositary orderJPARepositary;
	
	@Override
	@Transactional
	public Order save(Order order) throws CitywalkException {
		order = orderJPARepositary.save(order);
		return order;
	}

	@Override
	@Transactional(rollbackFor=CitywalkException.class)
	public void delete(int id) throws CitywalkException {
		orderJPARepositary.delete(id);
		return;
	}

	@Override
	@Transactional
	public List<Order> findAll() throws CitywalkException {
		List<Order> orders = orderJPARepositary.findAll();
		return orders;
	}

	@Override
	@Transactional(rollbackFor=CitywalkException.class)
	public Order update(Order order) throws CitywalkException {
		Order updatedOrder = orderJPARepositary.findOne(order.getOrderId());

		if (updatedOrder == null)
			throw new CitywalkException("Order not found");

		updatedOrder.setOrderedProduct(order.getOrderedProduct());
		updatedOrder.setOrderBy(order.getOrderBy());
		return updatedOrder;
	}

	@Override
	@Transactional
	public Order findById(int id) throws CitywalkException {
		Order order = orderJPARepositary.findOne(id);
		return order;
	}

}
