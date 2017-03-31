package com.citywalk.backend.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 7944542256960862502L;//this id useful in serialization and deserialization process

	@Id
	@GeneratedValue
	private Integer orderId;

	@Column(name = "order_by")
	private String orderBy;

	@Column(name = "ordered_product")
	private Integer orderedProduct;
	
	public Order() {
		super();
	}

	public Order(Integer orderId, String orderBy, Integer orderedProduct) {
		super();
		this.orderId = orderId;
		this.orderBy = orderBy;
		this.orderedProduct = orderedProduct;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getOrderedProduct() {
		return orderedProduct;
	}

	public void setOrderedProduct(Integer orderedProduct) {
		this.orderedProduct = orderedProduct;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderBy=" + orderBy + ", orderedProduct=" + orderedProduct + "]";
	}
}