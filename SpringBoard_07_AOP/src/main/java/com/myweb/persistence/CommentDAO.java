package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.CommentVO;
import com.myweb.domain.Criteria;

public interface CommentDAO {
	int insert(CommentVO cvo);
	List<CommentVO> selectList(Integer pno, Criteria cri);
	int update(CommentVO cvo);
	int delete(Integer cno);
	int selectOne(Integer pno);
	int selectPno(Integer cno);
}
