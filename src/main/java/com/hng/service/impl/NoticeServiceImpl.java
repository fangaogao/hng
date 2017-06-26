package com.hng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.bean.Page;
import com.hng.dao.IDao;
import com.hng.entity.Notice;
import com.hng.entity.vo.NoticeVO;
import com.hng.service.INoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements INoticeService {

	/**
	 * 注入dao
	 */
	@Autowired
	private IDao dao;
	
	//获取公告列表
	@Override
	public Page getNoticeList(Notice notice,int firstResult, int maxResults) {
		String hql = "select new com.hng.entity.vo.NoticeVO(n,n.users.userId) from Notice n";
		List<NoticeVO> list = dao.query(hql, null, firstResult, maxResults);
		int count = dao.queryCount(hql, null);
		Page page = new Page();
		page.setResult(list);
		page.setTotal(count);
		return page;
	}
	
}
