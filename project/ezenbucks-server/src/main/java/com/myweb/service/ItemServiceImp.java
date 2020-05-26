package com.myweb.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.domain.ItemVO;
import com.myweb.exception.ErrorCode;
import com.myweb.exception.RootException;
import com.myweb.persistence.ItemDAO;
/** 
 * Item 에 관련된 비즈니스 로직 처리하는 객체
 */
@Service
public class ItemServiceImp implements ItemService {
	private static final Logger log = LoggerFactory.getLogger(ItemServiceImp.class);
	
	@Autowired
	private ItemDAO itemdao;

	@Override
	public List<ItemVO> list() {
		try {
			return itemdao.selectList();
		} catch (SQLException e) {
			ErrorCode ec = ErrorCode.DBSelectError;
			throw new RootException(ec.getErrorCode(), ec.getMessage());
		}
	}

	/**
	 * 나중에 기능 추가시 구현
	 */
	@Override
	public List<ItemVO> selectList(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}