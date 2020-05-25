package com.myweb.persistence;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.domain.OrderDetailVO;
import com.myweb.domain.OrderVO;
/** DB 쿼리 작업을 위한 interface
 * 
 */
@Repository
public class OrderDAOImp implements OrderDAO{
	private static final Logger log = LoggerFactory.getLogger(OrderDAOImp.class);
	private static String namespace = "EzenbucksMapper";

	@Autowired
	private SqlSession sql;

	@Override
	public int save(OrderVO order) throws SQLException {
		return sql.insert(namespace + ".orderInsert", order);
	}
	
	@Override
	public void saveOrderDetail(OrderDetailVO order) throws SQLException {
		sql.insert(namespace + ".orderDetailInsert", order);
	}
}
