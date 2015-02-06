package com.rci.dao.repository;

import org.springframework.stereotype.Repository;

import com.rci.bean.entity.Order;
import com.rci.dao.impl.DefaultHibernateDAOFacadeImpl;

@Repository
public class OrderDAO extends DefaultHibernateDAOFacadeImpl<Order, Long> {

}
