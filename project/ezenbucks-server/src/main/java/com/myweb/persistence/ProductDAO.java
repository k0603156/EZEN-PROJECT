package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.ProductVO;

public interface ProductDAO {
	public List<ProductVO> selectList() throws SQLException;

}
