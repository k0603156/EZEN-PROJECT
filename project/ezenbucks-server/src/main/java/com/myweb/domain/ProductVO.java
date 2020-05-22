package com.myweb.domain;

import java.sql.Date;

public class ProductVO {
	private int pno;
	private String title;
	private String content;
	private String writer;
	private Date regd8;
	private Date modd8;
	private int readcount;
	private String imgfile;
	private int commentcnt;
	
	public ProductVO() {}
	
	public ProductVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}	
	public ProductVO(int pno, String title, String content) {
		this.pno = pno;
		this.title = title;
		this.content = content;
	}

	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getImgfile() {
		return imgfile;
	}
	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}

	public int getCommentcnt() {
		return commentcnt;
	}

	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
	}
	
}
