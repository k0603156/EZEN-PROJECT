package com.myweb.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.myweb.domain.ShopVO;
import com.myweb.persistence.ShopDAO;

@Service
public class ShopServiceImp implements ShopService {
	private static final Logger log = LoggerFactory.getLogger(ShopServiceImp.class);
	@Inject
	private ShopDAO shopdao;

	@Override
	public List<ShopVO> list() {
		try {
			return shopdao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
