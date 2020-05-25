package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.OrderDetailVO;

public interface OrderDetailDAO {
	public List<OrderDetailVO> selectList() throws SQLException;

}
