package com.myweb.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.OrderDetailVO;
import com.myweb.persistence.OrderDetailDAO;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
	private static final Logger log = LoggerFactory.getLogger(OrderDetailServiceImp.class);
	@Inject
	private OrderDetailDAO orderdetaildao;

	@Override
	public List<OrderDetailVO> list() {
		try {
			return orderdetaildao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
