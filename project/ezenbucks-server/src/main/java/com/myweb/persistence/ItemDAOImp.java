package com.myweb.persistence;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.domain.OptionVO;
import com.myweb.domain.ItemVO;

@Repository
public class ItemDAOImp implements ItemDAO {
	private static final Logger log = LoggerFactory.getLogger(ItemDAOImp.class);
	private static String namespace = "EzenbucksMapper";

	@Autowired
	private SqlSession sql;

	@Override
	public List<ItemVO> selectList() throws SQLException {	
		return sql.selectList(namespace + ".itemList");
	}

	@Override
	public int insertOption(OptionVO option) throws SQLException {
		return sql.insert(namespace + ".optionInsert" , option);
	}
}
