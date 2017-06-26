package com.hng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.dao.IDao;
import com.hng.entity.City;
import com.hng.entity.vo.CityVO;
import com.hng.service.ICityService;

@Service("cityService")
public class CityServiceImpl implements ICityService {

	/**
	 * 注入dao
	 */
	@Autowired
	private IDao dao;
	
	//获取省份列表
	@Override
	public List<CityVO> getProvince() {
		String hql = "select new com.hng.entity.vo.CityVO(c) from City c where LENGTH(c.levelCode)=2 and c.status='1'";
		List<CityVO> list = dao.query(hql);
		return list;
	}

	//获取市列表
	@Override
	public List<CityVO> getCity(City city) {
		String hql = "select new com.hng.entity.vo.CityVO(c) from City c where LENGTH(c.levelCode)=4 and c.status='1' "
				+ " and c.parentId=?";
		List<CityVO> list = dao.query(hql, city.getCityId());
		return list;
	}

	//获取区列表
	@Override
	public List<CityVO> getArea(City city) {
		String hql = "select new com.hng.entity.vo.CityVO(c) from City c where LENGTH(c.levelCode)=6 and c.status='1' "
				+ " and c.parentId=?";
		List<CityVO> list = dao.query(hql, city.getCityId());
		return list;
	}

}
