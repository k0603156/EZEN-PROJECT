package com.myweb.persistence;

import java.sql.SQLException;

import com.myweb.domain.OrderDetailVO;
import com.myweb.domain.OrderVO;
/** 
 * DB Order table 접근 클래스
 */
public interface OrderDAO {
	public int save(OrderVO order) throws SQLException;
	public void saveOrderDetail(OrderDetailVO order) throws SQLException;
}
