package com.myweb.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.domain.CoffeeVO;
import com.myweb.persistence.CoffeeDAO;

@Service
public class CoffeeServiceImp implements CoffeeService {
	private static final Logger log = LoggerFactory.getLogger(CoffeeServiceImp.class);
	@Inject
	private CoffeeDAO cdao;

	@Override
	public List<CoffeeVO> list() {
		try {
			return cdao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
