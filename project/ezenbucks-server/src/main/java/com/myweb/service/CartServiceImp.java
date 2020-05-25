package com.myweb.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.myweb.domain.CartVO;
import com.myweb.persistence.CartDAO;

@Service
public class CartServiceImp implements CartService {
	private static final Logger log = LoggerFactory.getLogger(CartServiceImp.class);
	@Inject
	private CartDAO cartdao;

	@Override
	public List<CartVO> list() {
		try {
			return cartdao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
