package com.myweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.FoodVO;

@Repository
public class FoodDAOImp implements FoodDAO {
	private static final Logger log = LoggerFactory.getLogger(FoodDAOImp.class);
	private static String namespace = "EzenbucksMapper";

	@Inject
	private SqlSession sql;

	@Override
	public List<FoodVO> selectList() {
		return sql.selectList(namespace + ".foodlist");
	}

}
