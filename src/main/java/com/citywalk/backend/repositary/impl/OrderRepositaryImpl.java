/*package com.citywalk.backend.repositary.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.Order;
import com.citywalk.backend.repositary.OrderRepositary;

public class OrderRepositaryImpl implements OrderRepositary {

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
*/