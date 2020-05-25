package com.myweb.persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.myweb.domain.OrderDetailVO;

@Repository
public class OrderDetailDAOImp implements OrderDetailDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderDetailDAOImp.class);
	private static String namespace = "EzenbucksMapper";

	@Inject
	private SqlSession sql;

	@Override
	public List<OrderDetailVO> selectList() throws SQLException {	
		return sql.selectList(namespace + ".orderdetail");
	}

}
