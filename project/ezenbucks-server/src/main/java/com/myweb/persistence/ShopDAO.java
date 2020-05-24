package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.ShopVO;

public interface ShopDAO {
	public List<ShopVO> selectList() throws SQLException;

}
