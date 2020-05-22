package com.myweb.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.domain.CommentDTO;
import com.myweb.domain.CommentVO;
import com.myweb.domain.Criteria;
import com.myweb.persistence.CommentDAO;
import com.myweb.persistence.ProductDAO;

@Service
public class CommentServiceImp implements CommentService{
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImp.class);
	@Inject
	private CommentDAO cdao;
	@Inject
	private ProductDAO pdao;
	
	@Transactional
	@Override
	public boolean write(CommentVO cvo) {
		int isOk = cdao.insert(cvo);
		int isUp = pdao.update(cvo.getPno(),1);
		return isOk==isUp;
	}
	@Override
	public CommentDTO list(Criteria cri, int pno) {
		// 이렇게 코딩하시면 초보티내는 겁니다!!!!
		/*List<CommentVO> list = cdao.selectList(pno, cri);
		int totalCnt = cdao.selectOne(pno);
		CommentDTO cdto = new CommentDTO(totalCnt, list);*/
		return new CommentDTO(cdao.selectOne(pno), cdao.selectList(pno, cri));  
	}
	@Override
	public int modify(CommentVO cvo) {
		return cdao.update(cvo);
	}
	@Transactional
	@Override
	public int remove(int cno) {
		int pno = cdao.selectPno(cno);
		int isRm = cdao.delete(cno);		
		int isDown = pdao.update(pno, -1);		
		return isRm*pno*isDown;
	}
	
	
}
