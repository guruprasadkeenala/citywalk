package com.citywalk.backend.repositary.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.citywalk.backend.modal.Order;

@Transactional
public interface OrderJPARepositary extends JpaRepository<Order, Integer> {

}
