package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.CartVO;

public interface CartDAO {
	public List<CartVO> selectList() throws SQLException;

}
