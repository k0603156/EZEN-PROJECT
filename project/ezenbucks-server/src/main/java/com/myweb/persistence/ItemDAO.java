package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.ItemVO;

public interface ItemDAO {
	public List<ItemVO> selectList() throws SQLException;

}
