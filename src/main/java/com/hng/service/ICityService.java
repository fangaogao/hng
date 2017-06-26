package com.hng.service;

import java.util.List;

import com.hng.entity.City;
import com.hng.entity.vo.CityVO;

public interface ICityService {
	
	/**
	 * 获取省份信息
	 * @return
	 */
	public List<CityVO> getProvince();
	
	/**
	 * 根据省份获取城市信息
	 * @param city
	 * @return
	 */
	public List<CityVO> getCity(City city);

	/**
	 * 根据城市获取区县信息
	 * @param city
	 * @return
	 */
	public List<CityVO> getArea(City city);
}
