package com.myweb.ctrl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.CommentVO;
import com.myweb.domain.ProductVO;
import com.myweb.persistence.CommentDAO;
import com.myweb.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DummyInsert {
	private static final Logger log = LoggerFactory.getLogger(DummyInsert.class);
	
	@Inject
	private ProductDAO pdao;
	@Inject
	private CommentDAO cdao;
	@Test
	public void dummyCmtTest() throws Exception {
		for (int i = 255; i > 240; i--) {
			int rnum = (int)(Math.random()*128);
			for (int j = 1; j < rnum; j++) {
				CommentVO cvo = new CommentVO();
				cvo.setPno(i);
				cvo.setContent(j+"번째 댓글 테스트");
				cvo.setWriter(j+"번째 댓글 작성자");
				cdao.insert(cvo);
			}
			
		}
	}
	
	@Test
	public void dummyTest() throws Exception{
		for (int i = 1; i < 256; i++) {
			ProductVO pvo = new ProductVO();
			pvo.setTitle(i+"번째 상품명");
			pvo.setWriter("더미 작성자" +i);
			pvo.setContent("더미 상세 내용 " + i);
			pvo.setImgfile("NONE");
			pdao.insert(pvo);
		}
	}
}






















