package com.hng.service;

import java.util.List;

import com.hng.bean.Page;
import com.hng.entity.AgriculClas;
import com.hng.entity.vo.AgriculClasVO;

public interface IAgriculClasService {
	
	/**
	 * 获取三层分类
	 * @return
	 */
	public List<AgriculClas> getThreeClas();

	/**
	 * 获取品种列表
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public Page getClasList(AgriculClas clas,int firstResult, int maxResults);
	
	/**
	 * 获取一级产品分类
	 * @return
	 */
	public List<AgriculClasVO> getFirstClas();
	/**
	 * 获取二级产品分类
	 * @return
	 */
	public List<AgriculClasVO> getSecondClas(AgriculClas first);
	/**
	 * 获取三级产品分类
	 * @return
	 */
	public List<AgriculClasVO> getThirdClas(AgriculClas second);
}
