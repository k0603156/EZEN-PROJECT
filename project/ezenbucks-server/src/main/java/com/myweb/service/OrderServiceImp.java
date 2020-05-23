package com.myweb.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.OrderVO;
import com.myweb.persistence.OrderDAO;

@Service
public class OrderServiceImp implements OrderService {
	private static final Logger log = LoggerFactory.getLogger(OrderServiceImp.class);
	@Inject
	private OrderDAO orderdao;

	@Override
	public List<OrderVO> list() {
		try {
			return orderdao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
