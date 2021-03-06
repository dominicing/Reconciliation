package com.rci.datafetch;

import java.util.Date;
import java.util.List;

import com.rci.bean.DishDTO;
import com.rci.bean.DishTypeDTO;
import com.rci.bean.OrderDTO;
import com.rci.bean.OrderItemDTO;
import com.rci.bean.PaymodeDTO;

public interface IDataFetchService {
	OrderDTO fetchOrderByNo(String orderNo);
	
	List<OrderDTO> fetchAllDayOrders(Date sdate,Date edate);
	
	List<OrderItemDTO> fetchOrderItemsByOrder(String orderNo);
	
	List<DishDTO> fetchDish();
	
	List<DishDTO> fetchDishByTypeNo(String typeno);
	
	List<DishTypeDTO> fetchDishType();
	
	public DishTypeDTO fetchDishyTypeByNo(String typeno);
	
	List<String> fetchSchemeDishTypeNoRef(String schemeNo);
	
	List<PaymodeDTO> fetchPaymodes();
}
