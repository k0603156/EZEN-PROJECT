package com.myweb.ctrl;


import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.ProductVO;
import com.myweb.persistence.ProductDAO;
import com.myweb.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DaoTest {
	
	@Inject
	ProductDAO dao; 
 
	@Test
	public void detail() {
		int product_id = 1; 
		ProductVO vo = dao.selectOne(product_id);
		System.out.println();
	}
}
