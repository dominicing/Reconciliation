package com.rci.service.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.dozer.Mapper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rci.bean.entity.Order;
import com.rci.bean.entity.PostOrderAccount;
import com.rci.service.BaseService;
import com.rci.service.IOrderService;
import com.rci.tools.StringUtility;
import com.rci.ui.vo.OrderVO;

@Service("OrderService")
public class OrderServiceImpl extends BaseService<Order, Long> implements
		IOrderService {
	@Autowired
	private Mapper beanMapper;

	@Override
	public Order getOrder(Long pk) {
		return super.get(pk);
	}

	@Override
	public void rwInsertOrder(Order order) {
		rwCreate(order);
	}

	@Override
	public List<Order> queryAllDayOrders() {
		return null;
	}

	@Override
	public List<Order> queryOrdersByDay(String day) {
		if(!StringUtility.isDateFormated(day)){
			System.out.println("日期格式不正确");
			return null;
		}
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.eq("day", day));
		List<Order> orders = baseDAO.queryListByCriteria(dc);
		return orders;
	}

	@Override
	public List<OrderVO> queryOrderVOsByDay(String day) {
		List<Order> orders = queryOrdersByDay(day);
		List<OrderVO> vos = new LinkedList<OrderVO>();
		if(!CollectionUtils.isEmpty(orders)){
			for(Order order:orders){
				OrderVO vo = beanMapper.map(order, OrderVO.class);
				List<PostOrderAccount> poas = order.getPostOrderAccounts();
				BigDecimal totalAmount = BigDecimal.ZERO;
				for(PostOrderAccount account:poas){
					if(account.getAccountId() == 1){
						vo.setPosAmount(account.getPostAmount());
					}
					if(account.getAccountId() == 2){
						vo.setMtAmount(account.getPostAmount());
					}
					if(account.getAccountId() == 3){
						vo.setDptgAmount(account.getPostAmount());
					}
					if(account.getAccountId() == 4){
						vo.setDpshAmount(account.getPostAmount());
					}
					if(account.getAccountId() == 5){
						vo.setEleAmount(account.getPostAmount());
					}
					if(account.getAccountId() == 6){
						vo.setTddAmount(account.getPostAmount());
					}
				}
				if(vo.getPosAmount() != null){
					totalAmount = totalAmount.add(vo.getPosAmount());
				}
				if(vo.getMtAmount() != null){
					totalAmount = totalAmount.add(vo.getMtAmount());
				}
				if(vo.getDptgAmount() != null){
					totalAmount = totalAmount.add(vo.getDptgAmount());
				}
				if(vo.getDpshAmount() != null){
					totalAmount = totalAmount.add(vo.getDpshAmount());
				}
				if(vo.getEleAmount() != null){
					totalAmount = totalAmount.add(vo.getEleAmount());
				}
				if(vo.getTddAmount() != null){
					totalAmount = totalAmount.add(vo.getTddAmount());
				}
				vo.setSchemeName(order.getScheme().getsName());
				vo.setTotalAmount(totalAmount);
				vos.add(vo);
			}
		}
		return vos;
	}
}
