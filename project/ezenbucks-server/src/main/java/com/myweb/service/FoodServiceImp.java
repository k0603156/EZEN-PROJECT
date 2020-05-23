package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.FoodVO;
import com.myweb.persistence.FoodDAO;

@Service
public class FoodServiceImp implements FoodService {
	private static final Logger log = LoggerFactory.getLogger(FoodServiceImp.class);
	@Inject
	private FoodDAO fdao;

	@Override
	public List<FoodVO> list() {
		return fdao.selectList();
	}

}
