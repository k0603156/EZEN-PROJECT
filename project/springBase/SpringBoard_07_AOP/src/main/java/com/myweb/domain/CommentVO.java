package com.myweb.domain;

import java.util.Date;

public class CommentVO {
	private int cno;
	private int pno;
	private String content;
	private String writer;
	private Date regd8;
	private Date modd8;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegd8() {
		return regd8;
	}
	public void setRegd8(Date regd8) {
		this.regd8 = regd8;
	}
	public Date getModd8() {
		return modd8;
	}
	public void setModd8(Date modd8) {
		this.modd8 = modd8;
	}
	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", pno=" + pno + ", content=" + content + ", writer=" + writer + ", regd8="
				+ regd8 + ", modd8=" + modd8 + "]";
	}
}
