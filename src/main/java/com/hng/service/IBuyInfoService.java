package com.hng.service;

import java.util.List;

import com.hng.bean.Page;
import com.hng.entity.BuyInfo;
import com.hng.entity.Member;
import com.hng.entity.vo.BuyInfoVO;

public interface IBuyInfoService {
	
	/**
	 * 获取求购信息
	 * @param info
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public Page getBuyInfoList(BuyInfo info,int firstResult, int maxResults);
	
	/**
	 * 保存求购信息
	 * @param info
	 * @return
	 */
	public BuyInfo saveBuyInfo(BuyInfo info);
	
	
	/**
	 * 查询会员求购信息
	 * @param member
	 * @return
	 */
	public List<BuyInfoVO> getBuyInfoByMember(Member member);

	/**
	 * 获取求购信息详情
	 * @param info
	 * @return
	 */
	public BuyInfoVO getBuyInfoById(BuyInfo info);
	
	/**
	 * 增加访问次数
	 * @param buyId
	 */
	public void addAccessTime(int buyId);
}
