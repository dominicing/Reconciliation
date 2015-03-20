package com.rci.service.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rci.bean.OrderItemDTO;
import com.rci.bean.entity.Order;

@Component("FilterChain")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FilterChain implements CalculateFilter {
	List<CalculateFilter> filters = new ArrayList<CalculateFilter>();
	int pos = 0;
	
	public FilterChain addFilter(CalculateFilter filter){
		this.filters.add(filter);
		return this;
	}
	
	public FilterChain addFilters(List<CalculateFilter> filters){
		this.filters.addAll(filters);
		return this;
	}
	
	
	@Override
	public void doFilter(Order order, List<OrderItemDTO> items,
			FilterChain chain) {
		if(pos == filters.size()){
			return;
		}
		CalculateFilter filter = filters.get(pos);
		pos++;
		filter.doFilter(order, items, chain);
	}

	@Override
	public boolean support(Map<String, BigDecimal> paymodeMapping) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getChit() {
		throw new UnsupportedOperationException();
	}
	
	public void reset(){
		this.pos = 0;
	}

}