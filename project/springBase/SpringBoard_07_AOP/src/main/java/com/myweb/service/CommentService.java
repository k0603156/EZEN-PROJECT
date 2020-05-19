package com.myweb.service;

import com.myweb.domain.CommentDTO;
import com.myweb.domain.CommentVO;
import com.myweb.domain.Criteria;

public interface CommentService {
	boolean write(CommentVO cvo);
	CommentDTO list(Criteria cri, int pno);
	int modify(CommentVO cvo);
	int remove(int cno);
}
