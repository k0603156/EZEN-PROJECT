package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.FoodVO;

public interface FoodDAO {
	public List<FoodVO> selectList();

}
