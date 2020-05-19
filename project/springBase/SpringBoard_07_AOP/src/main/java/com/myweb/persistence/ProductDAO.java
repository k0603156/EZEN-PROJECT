package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.ProductVO;

public interface ProductDAO {
	public void insert(ProductVO pvo);
	public List<ProductVO> selectList(Criteria cri);
	public ProductVO selectOne(Integer pno);
	public void update(ProductVO pvo);
	public void delete(Integer pno);
	public int deleteImg(Integer pno);
	public int selectOne(Criteria cri);
	public void update(Integer pno);
	public int update(Integer pno, Integer sign);
}
