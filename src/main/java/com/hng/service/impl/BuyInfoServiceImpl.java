package com.hng.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.bean.Page;
import com.hng.dao.IDao;
import com.hng.entity.BuyInfo;
import com.hng.entity.Member;
import com.hng.entity.vo.BuyInfoVO;
import com.hng.service.IBuyInfoService;

@Service("buyInfoService")
public class BuyInfoServiceImpl implements IBuyInfoService {

	/**
	 * 注入dao
	 */
	@Autowired
	private IDao dao;
	
	//获取求购信息列表
	@Override
	public Page getBuyInfoList(BuyInfo info, int firstResult, int maxResults) {
		String hql = "select new com.hng.entity.vo.BuyInfoVO(info,c1,c2,c3,m,clas) from BuyInfo info "
				+ " left outer join info.cityByProvinceId c1"
				+ " left outer join info.cityByCityId c2"
				+ " left outer join info.cityByAreaId c3 "
				+ " left outer join info.member m"
				+ " left outer join info.agriculClas clas ";
		List<BuyInfoVO> list = dao.query(hql, null, firstResult, maxResults);
		int count = dao.queryCount(hql, null);
		Page page = new Page();
		page.setResult(list);
		page.setTotal(count);
		return page;
	}

	//保存求购信息
	@Override
	public BuyInfo saveBuyInfo(BuyInfo info) {
		Date date = new Date();
		//发布时间
		info.setPublishDate( new Timestamp(date.getTime()));
		//到期时间
		Calendar cld=Calendar.getInstance();
		cld.setTime(date);
		cld.add(Calendar.DATE, info.getExpiryInterval());
		info.setExpiryDate(new Timestamp(cld.getTime().getTime()));
		info.setAccessTimes(0);
		info.setCollectTimes(0);
		dao.save(info);
		return info;
	}

	//获取会员求购列表
	@SuppressWarnings("unchecked")
	@Override
	public List<BuyInfoVO> getBuyInfoByMember(Member member) {
		String hql = "select new com.hng.entity.vo.BuyInfoVO(info) from BuyInfo info where info.member.memberId=? and status!='0'";
		return (List<BuyInfoVO>)dao.query(hql, member.getMemberId());
	}

	//获取求购信息详情
	@Override
	public BuyInfoVO getBuyInfoById(BuyInfo info) {
		String hql = "select new com.hng.entity.vo.BuyInfoVO(info,c1,c2,c3,m,clas) from BuyInfo info "
				+ " left outer join info.cityByProvinceId c1"
				+ " left outer join info.cityByCityId c2"
				+ " left outer join info.cityByAreaId c3 "
				+ " left outer join info.member m"
				+ " left outer join info.agriculClas clas "
				+ " where info.buyId=? and info.status!='0'";
		List<BuyInfoVO> list = dao.query(hql, info.getBuyId());
		if(list!=null&&list.size()>0)
			return (BuyInfoVO)list.get(0);
		return null;
	}

	//增加访问次数
	@Override
	public void addAccessTime(int buyId) {
		String hql = "update BuyInfo info set info.accessTimes=info.accessTimes+1 where info.buyId=?";
		dao.execute(hql, buyId);
	}
	
	

}
