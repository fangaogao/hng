package com.hng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.bean.Page;
import com.hng.dao.IDao;
import com.hng.entity.AgriculClas;
import com.hng.entity.vo.AgriculClasVO;
import com.hng.service.IAgriculClasService;

@Service("agriculClasService")
public class AgriculClasServiceImpl implements IAgriculClasService {

	/**
	 * 注入dao
	 */
	@Autowired
	private IDao dao;
	
	/**
	 * 获取三层分类
	 * @return
	 */
	@Override
	public List<AgriculClas> getThreeClas() {
		String hql = "from AgriculClas clas where LENGTH(clas.levelCode)=2";
		List<AgriculClas> list = dao.query(hql);
		return list;
	}

	//获取品种列表
	@Override
	public Page getClasList(AgriculClas clas,int firstResult, int maxResults) {
		String hql = "select new com.hng.entity.vo.AgriculClasVO(clas,clas.agriculClas.clasId) from AgriculClas clas";
		List<AgriculClasVO> list = dao.query(hql, null, firstResult, maxResults);
		int count = dao.queryCount(hql, null);
		Page page = new Page();
		page.setResult(list);
		page.setTotal(count);
		return page;
	}

	@Override
	public List<AgriculClasVO> getFirstClas() {
		String hql = "select new com.hng.entity.vo.AgriculClasVO(clas,clas.agriculClas.clasId) from AgriculClas clas where LENGTH(clas.levelCode)=2 and clas.status='1'";
		List<AgriculClasVO> list = dao.query(hql);
		return list;
	}

	@Override
	public List<AgriculClasVO> getSecondClas(AgriculClas first) {
		String hql = "select new com.hng.entity.vo.AgriculClasVO(clas,clas.agriculClas.clasId) from AgriculClas clas "
				+ "where LENGTH(clas.levelCode)=4 and clas.status='1' and clas.agriculClas.clasId=?";
		List<AgriculClasVO> list = dao.query(hql,first.getClasId());
		return list;
	}

	@Override
	public List<AgriculClasVO> getThirdClas(AgriculClas second) {
		String hql = "select new com.hng.entity.vo.AgriculClasVO(clas,clas.agriculClas.clasId) from AgriculClas clas "
				+ "where LENGTH(clas.levelCode)=6 and clas.status='1' and clas.agriculClas.clasId=?";
		List<AgriculClasVO> list = dao.query(hql,second.getClasId());
		return list;
	}

	

}
