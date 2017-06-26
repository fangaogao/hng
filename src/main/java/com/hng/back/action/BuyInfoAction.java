package com.hng.back.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hng.base.BaseAction;
import com.hng.entity.BuyInfo;
import com.hng.entity.Users;
import com.hng.service.IBuyInfoService;
import com.hng.util.Constants;
import com.hng.util.ControllerUtil;

@Controller
@Scope("prototype")
public class BuyInfoAction extends BaseAction {
	@Autowired
	private IBuyInfoService buyInfoService;
	private BuyInfo buyInfo;
	
	private String result;
	
	//求购管理页面
	public String index() throws Exception {
		Users user = (Users) session.getAttribute(Constants.CURRENT_USER);
		if (user == null)
			return ERROR;
		return SUCCESS;
	}
	
	
	//获取求购列表
	public void getBuyInfoList() throws Exception{
		// 分页信息
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int maxResults = StringUtils.isBlank(rows) ? 10 : Integer.parseInt(rows);
		int firstResult = StringUtils.isBlank(page) ? 0 : (Integer.parseInt(page) - 1) * maxResults;
		ControllerUtil.out(response, buyInfoService.getBuyInfoList(buyInfo, firstResult, maxResults));
	}
	
	public BuyInfo getBuyInfo() {
		return buyInfo;
	}


	public void setBuyInfo(BuyInfo buyInfo) {
		this.buyInfo = buyInfo;
	}


	
}
