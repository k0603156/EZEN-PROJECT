package com.myweb.service;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.ProductVO;

public interface ProductService {
	public void write(ProductVO pvo);
	public List<ProductVO> list(Criteria cri);
	public ProductVO detail(Integer pno);
	public void modify(ProductVO pvo);
	public void remove(Integer pno);
	public int removeImg(Integer pno);
	public int totalCount(Criteria cri);
}
