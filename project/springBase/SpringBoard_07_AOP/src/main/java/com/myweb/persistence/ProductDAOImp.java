package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criteria;
import com.myweb.domain.ProductVO;

@Repository
public class ProductDAOImp implements ProductDAO{
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImp.class);
	private static String ns = "ProductMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int deleteImg(Integer pno) {
		Map<String,Object> map = new HashMap<>();
		map.put("pno",pno);
		map.put("imgfile", "NONE");
		return sql.update(ns+"rmImg",map);
	}
	@Override
	public void insert(ProductVO pvo) {
		sql.insert(ns+"add",pvo);		
	}

	@Override
	public List<ProductVO> selectList(Criteria cri) {
		return sql.selectList(ns+"list", cri);
	}

	@Override
	public ProductVO selectOne(Integer pno) {
		return sql.selectOne(ns+"detail", pno);
	}

	@Override
	public void update(ProductVO pvo) {
		sql.update(ns+"modify", pvo);
	}

	@Override
	public void delete(Integer pno) {
		sql.delete(ns+"remove", pno);
	}
	@Override
	public int selectOne(Criteria cri) {
		return sql.selectOne(ns+"total",cri);
	}
	@Override
	public int update(Integer pno, Integer sign) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("pno", pno);
		map.put("sign", sign);
		return sql.update(ns+"upCount", map);
	}
	@Override
	public void update(Integer pno) {
		sql.update(ns+"upReadCount", pno);		
	}
}
