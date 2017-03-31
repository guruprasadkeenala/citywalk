package com.citywalk.backend.service;

import java.util.List;

import com.citywalk.backend.exception.CitywalkException;
import com.citywalk.backend.modal.Order;

public interface OrderService {
	public Order save(Order order) throws CitywalkException;
	public void delete(int id) throws CitywalkException;
	public List<Order> findAll() throws CitywalkException;
	public Order update(Order order) throws CitywalkException;
	public Order findById(int id) throws CitywalkException;
}
