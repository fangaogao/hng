package com.hng.front.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.Member;
import com.hng.entity.Users;
import com.hng.service.IMemberService;
import com.hng.util.Constants;


/** 会员信息控制器*/
@Controller
@Scope("prototype")
public class IMemberAction  extends BaseAction {
	@Autowired
	private IMemberService memberService;
	public Member member;
	private String result;
	
	// 获取我的惠农首页
	public String getMyIndex() throws Exception  {
		Users user = (Users) request.getSession().getAttribute(Constants.CURRENT_USER);
		if(user!=null&&user.getUserId()!=null){
//			member = memberService.getMyInfo(user.getUserId());
//			request.setAttribute("member", member);
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
	}
	// 获取我的惠农首页信息
	public String getMyIndexInfo() throws Exception  {
		Users user = (Users) request.getSession().getAttribute(Constants.CURRENT_USER);
		if(user!=null&&user.getUserId()!=null){
			member = memberService.getMyInfo(user.getUserId());
			request.setAttribute("member", member);
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
	}
   
   /** 获取会员信息
    * 
    * @pdOid 750ff43f-0c9e-4755-81b0-2659995f7818 */
   public String getMemberInfo() {
      // TODO: implement
      return null;
   }
   
   /** 修改会员信息
    * 
    * @pdOid 27c38b54-bfd7-4c7b-87e6-cdd18f71d2ae */
   public String updateMember() {
      // TODO: implement
      return null;
   }
   
   /** 个人实名认证
    * 
    * @pdOid f77b66b8-a373-4ac7-8a65-663ffe052191 */
   public String memberIdentity() {
      // TODO: implement
      return null;
   }
   
   /** 上传头像
    * 
    * @pdOid 05a5dea0-239c-4eee-a36a-55a8ab319070 */
   public String uploadHead() {
      // TODO: implement
      return null;
   }
   
   /** 修改密码
    * 
    * @pdOid 0aa12bd8-e0f8-414e-a9c6-4c24cdaba9da */
   public String updatePwd() {
      // TODO: implement
      return null;
   }


	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

   
}