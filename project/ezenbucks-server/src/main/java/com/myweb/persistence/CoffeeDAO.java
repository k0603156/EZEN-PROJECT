package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.CoffeeVO;

public interface CoffeeDAO {
	public List<CoffeeVO> selectList();

}
