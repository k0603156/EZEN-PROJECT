package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.OrderVO;

public interface OrderDAO {
	public List<OrderVO> selectList() throws SQLException;

}
