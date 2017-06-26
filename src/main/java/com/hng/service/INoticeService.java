package com.hng.service;

import com.hng.bean.Page;
import com.hng.entity.Notice;

public interface INoticeService {

	/**
	 * 获取公告列表
	 * @param notic
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public Page getNoticeList(Notice notice,int firstResult, int maxResults);
}
