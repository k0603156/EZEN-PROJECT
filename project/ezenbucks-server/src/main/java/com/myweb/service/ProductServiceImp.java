package com.myweb.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.myweb.domain.ProductVO;
import com.myweb.persistence.ProductDAO;

@Service
public class ProductServiceImp implements ProductService {
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImp.class);
	@Inject
	private ProductDAO pdao;

	@Override
	public List<ProductVO> list() {
		try {
			return pdao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
