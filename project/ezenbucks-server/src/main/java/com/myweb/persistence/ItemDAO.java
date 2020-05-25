package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import com.myweb.domain.OptionVO;
import com.myweb.domain.ItemVO;
/** 
 * DB Item table 조작하거나 처리하는 객체
 */
public interface ItemDAO {
	public List<ItemVO> selectList() throws SQLException;
	public int insertOption(OptionVO option) throws SQLException;
}
