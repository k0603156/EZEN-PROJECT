package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.CoffeeVO;

public interface CoffeeDAO {
	public List<CoffeeVO> selectList() throws SQLException;

}
