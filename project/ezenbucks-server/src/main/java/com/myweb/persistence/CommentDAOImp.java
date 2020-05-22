package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.CommentVO;
import com.myweb.domain.Criteria;

@Repository
public class CommentDAOImp implements CommentDAO{
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImp.class);
	private static String ns = "CommentMapper.";
	@Inject
	private SqlSession sql;
	@Override
	public int insert(CommentVO cvo) {
		return sql.insert(ns+"add", cvo);
	}

	@Override
	public List<CommentVO> selectList(Integer pno, Criteria cri) {
		Map<String, Object> map = new HashMap<>();
		map.put("pno", pno);
		map.put("cri", cri);
		return sql.selectList(ns+"list", map);
	}

	@Override
	public int update(CommentVO cvo) {
		return sql.update(ns+"modify", cvo);
	}

	@Override
	public int delete(Integer cno) {
		return sql.delete(ns+"remove", cno);
	}

	@Override
	public int selectOne(Integer pno) {
		return sql.selectOne(ns+"total", pno);
	}

	@Override
	public int selectPno(Integer cno) {
		return sql.selectOne(ns+"getPno", cno);
	}
}
