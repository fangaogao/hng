package com.hng.service;

import java.util.List;

import com.hng.bean.Page;
import com.hng.entity.Member;
import com.hng.entity.Users;

public interface IMemberService {
	
	/**
	 * 新增会员
	 * @param member
	 * @return
	 */
	public Member saveMember(Users user);
	
	/**
	 * 获取当前会员信息
	 * @param userId 当前用户id
	 * @return
	 */
	public Member getMyInfo(int userId);
	
	/**
	 * 获取所有会员
	 * @param member
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public Page getMemberList(Member member,int firstResult, int maxResults);
	
	/**
	 * 获取会员信息
	 * @param memberId
	 * @return
	 */
	public Member getMemberInfoById(int memberId);
	   /** 修改会员信息
	* 
	* @pdOid c6822f11-6c48-40d6-92b1-4dd5074f3297 */
	   List<Member> updateMember();
	   /** 个人实名认证
	* 
	* @pdOid c8ea465e-0b3b-4022-a212-b12401e81851 */
	   List<Member> memberIdentity();
	   /** 上传头像
	* 
	* @pdOid 0bff3c03-e09d-4db4-b362-e3065e2fc715 */
	   List<Member> uploadHead();
	   /** 修改密码
	* 
	* @pdOid f592fc3c-91b2-4811-bbad-cbacfb82ade7 */
	   List<Member> updatePwd();
	   /** 禁用会员账户
	* 
	* @pdOid 916ac8a0-bc12-4c88-9d97-dc7edc5512ae */
	   Member forbiddenMember();

}