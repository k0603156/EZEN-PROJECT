package com.myweb.domain;

import java.util.List;

public class CommentDTO {
	private int commentcnt;
	private List<CommentVO> list;
	public CommentDTO() {}
	public CommentDTO(int commentcnt, List<CommentVO> list) {
		this.commentcnt = commentcnt;
		this.list = list;
	}
	public int getCommentcnt() {
		return commentcnt;
	}
	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
	}
	public List<CommentVO> getList() {
		return list;
	}
	public void setList(List<CommentVO> list) {
		this.list = list;
	}	
}
