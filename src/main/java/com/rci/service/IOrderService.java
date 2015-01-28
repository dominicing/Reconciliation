package com.rci.service;

import java.util.List;

import com.rci.bean.entity.Order;

public interface IOrderService {
	Order getOrder(Long pk);
	
	void rwInsertOrder(Order order);
	
	List<Order> queryAllDayOrders();
}
