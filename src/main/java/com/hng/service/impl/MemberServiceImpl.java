package com.hng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hng.bean.Page;
import com.hng.dao.IDao;
import com.hng.entity.Member;
import com.hng.entity.Users;
import com.hng.entity.vo.MemberVO;
import com.hng.service.IMemberService;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {

	/**
	 * 注入dao
	 */
	@Autowired
	private IDao dao;
	
	//新增会员
	@Override
	public Member saveMember(Users user) {
		Member member = new Member();
		member.setEmail(user.getLoginName());
		member.setUsers(user);
		//账户状态为1-启用
		member.setMemberStatus("1");
		//认证状态为0-未认证
		member.setCertificationStatus("0");
		dao.save(member);
		return member;
	}

	
	@Override
	public Member getMyInfo(int userId) {
		String hql = "from Member m where m.users.userId=?";
		List<Member> members = dao.query(hql, userId);
		if(members!=null&&members.size()>0){
			return members.get(0);
		}
		return null; 
	}
	
	
	//获取所有会员信息
	@Override
	public Page getMemberList(Member member, int firstResult, int maxResults) {
		String hql = "select new com.hng.entity.vo.MemberVO(m,c1,c2,c3,com,u) from Member m left outer join m.cityByProvinceId c1 "
				+ " left outer join m.cityByCityId c2 "
				+ " left outer join m.cityByAreaId c3 "
				+ " left outer join m.company com"
				+ " left outer join m.users u";
		List<MemberVO> list = dao.query(hql, null, firstResult, maxResults);
		int count = dao.queryCount(hql, null);
		Page page = new Page();
		page.setResult(list);
		page.setTotal(count);
		return page;
	}

	//获取会员信息
	@Override
	public Member getMemberInfoById(int memberId) {
		String hql = "from Member m where m.users.memberId=?";
		List<Member> members = dao.query(hql, memberId);
		if(members!=null&&members.size()>0){
			return members.get(0);
		}
		return null; 
	}

	@Override
	public List<Member> updateMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> memberIdentity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> uploadHead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> updatePwd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member forbiddenMember() {
		// TODO Auto-generated method stub
		return null;
	}



}
