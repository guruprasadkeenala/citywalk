package com.citywalk.backend.repositary.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citywalk.backend.modal.Order;

public interface OrderJPARepositary extends JpaRepository<Order, Integer> {

}
