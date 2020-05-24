package com.myweb.service;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.myweb.domain.ItemVO;
import com.myweb.persistence.ItemDAO;

@Service
public class ItemServiceImp implements ItemService {
	private static final Logger log = LoggerFactory.getLogger(ItemServiceImp.class);
	@Inject
	private ItemDAO itemdao;

	@Override
	public List<ItemVO> list() {
		try {
			return itemdao.selectList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
