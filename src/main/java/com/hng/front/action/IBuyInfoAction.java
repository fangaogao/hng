package com.hng.front.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.BuyInfo;
import com.hng.entity.Member;
import com.hng.entity.Users;
import com.hng.entity.vo.BuyInfoVO;
import com.hng.service.IBuyInfoService;
import com.hng.service.IMemberService;
import com.hng.util.Constants;

@Controller
@Scope("prototype")
public class IBuyInfoAction  extends BaseAction{
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IBuyInfoService buyInfoService;
	private BuyInfo buyInfo;

	
	//获取发布信息页面
	public String index() throws Exception {
		Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
		if (user == null)
			return ERROR;
		return SUCCESS;
	}
	
	//保存求购信息
	public String saveBuyInfo() throws Exception {
		Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
		if(user == null)
			return ERROR;
		Member member = memberService.getMyInfo(user.getUserId());
		buyInfo.setMember(member);
		buyInfoService.saveBuyInfo(buyInfo);
		return SUCCESS;
	}
	
	//获取会员求购列表
	public String getBuyInfoByMember() throws Exception {
		Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
		if(user == null)
			return ERROR;
		Member member = memberService.getMyInfo(user.getUserId());
		List<BuyInfoVO> buyList = buyInfoService.getBuyInfoByMember(member);
		request.setAttribute("buyList", buyList);
		return SUCCESS;
	}
	
	//获取会员求购详情
	public String getBuyInfoById() throws Exception {
		String result = ERROR;
		//求购信息
		String buyId = request.getParameter("buyId");
		if(buyId==null||"".equals(buyId))
			return ERROR;
		buyInfo.setBuyId(Integer.valueOf(buyId));
		BuyInfoVO buyInfoVO = buyInfoService.getBuyInfoById(buyInfo);
		if(buyInfoVO==null)
			return ERROR;
		//当是1,2,3状态的信息,判断当前是否有用户登录
		if(buyInfoVO.getStatus()!=null&&("1".equals(buyInfoVO.getStatus())
				||"2".equals(buyInfoVO.getStatus())||"3".equals(buyInfoVO.getStatus()))){
			Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
			if(user == null)
				return ERROR;
			result = "pubInfo";
		}
		
		Member member = new Member();
		//当是4,5状态的信息，增加访问次数，获取会员信息
		if(buyInfoVO.getStatus()!=null&&("4".equals(buyInfoVO.getStatus())||"5".equals(buyInfoVO.getStatus()))){
			buyInfoService.addAccessTime(buyInfoVO.getBuyId());
			//会员信息
			member = memberService.getMemberInfoById(buyInfoVO.getMemberId());
			result = "buyInfo";
		}
		
		request.setAttribute("buyInfo", buyInfoVO);
		request.setAttribute("member", member);
		return result;
	}

	public BuyInfo getBuyInfo() {
		return buyInfo;
	}

	public void setBuyInfo(BuyInfo buyInfo) {
		this.buyInfo = buyInfo;
	}
	
}
